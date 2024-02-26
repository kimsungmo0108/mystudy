package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() {
    this.boardDao = (BoardDaoImpl) this.getServletContext().getAttribute("boardDao");
    this.attachedFileDao = (AttachedFileDaoImpl) this.getServletContext()
        .getAttribute("attachedFileDao");
    this.txManager = (TransactionManager) this.getServletContext().getAttribute("txManager");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int category = Integer.parseInt(request.getParameter("category"));
      String title = category == 1 ? "게시글" : "가입인사";

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다.");
      }

      int no = Integer.parseInt(request.getParameter("no"));
      Board board = boardDao.findBy(no);
      if (board == null) {
        throw new Exception("번호가 유효하지 않습니다.");
      } else if (board.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      }

      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));
      board.setWriter(loginUser);

      ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

      String[] files = request.getParameterValues("files");
      if (files != null) {
        for (String file : files) {
          if (file.length() == 0) {
            continue;
          }
          attachedFiles.add(new AttachedFile().filePath(file));
        }
      }

      txManager.startTransaction();

      boardDao.update(board);

      if (attachedFiles.size() > 0) {
        // 첨부파일 객체에 게시글 번호 저장
        for (AttachedFile file : attachedFiles) {
          file.setBoardNo(board.getNo());
        }
        attachedFileDao.addAll(attachedFiles);
      }

      txManager.commit();

      response.sendRedirect("/board/list?category=" + category);

    } catch (Exception e) {
      request.setAttribute("message", "변경 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
    }
  }
}
