package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/file/delete")
public class BoardFileDeleteServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() {
    this.boardDao = (BoardDaoImpl) this.getServletContext().getAttribute("boardDao");
    this.attachedFileDao = (AttachedFileDaoImpl) this.getServletContext()
        .getAttribute("attachedFileDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser == null) {
        throw new Exception("로그인하시기 바랍니다!");
      }

      int fileNo = Integer.parseInt(request.getParameter("no"));

      AttachedFile file = attachedFileDao.findByNo(fileNo);
      if (file == null) {
        throw new Exception("첨부파일 번호가 유효하지 않습니다.");
      }

      Member writer = boardDao.findBy(file.getBoardNo()).getWriter();

      if (writer.getNo() != loginUser.getNo()) {
        throw new Exception("권한이 없습니다.");
      } else {
        attachedFileDao.delete(fileNo);
      }

    } catch (Exception e) {
      request.setAttribute("message", "첨부파일 삭제 오류!");
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
    }
  }
}
