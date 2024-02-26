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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  @Override
  public void init() {
    this.boardDao = (BoardDaoImpl) this.getServletContext().getAttribute("boardDao");
    this.txManager = (TransactionManager) this.getServletContext().getAttribute("txManager");
    this.attachedFileDao = (AttachedFileDaoImpl) this.getServletContext()
        .getAttribute("atttachedFileDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int category = Integer.parseInt(request.getParameter("category"));
    String title = category == 1 ? "게시글" : "가입인사";

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang = 'en'>");
    out.println("<head>");
    out.println("   <meta charset = 'UTF-8'>");
    out.println("   <title> 비트캠프 데브옵스 5 기 </title>");
    out.println("</head>");
    out.println("<body>");
    out.printf("<h1>%s</h1>\n", title);

    out.printf("<form action='/board/add?category=%d' method='post'>\n", category);
    out.printf("<input name='category' type='hidden' value='%d'>\n", category);
    out.println("<div>");
    out.println("제목: <input name='title' type='text'>");
    out.println("</div>");
    out.println("<div>");
    out.println("내용: <textarea name='content'></textarea>");
    out.println("</div>");
    out.println("<div>");
    if (category == 1) {
      out.println("첨부파일: <input multiple name='files' type='file'>");
      out.println("</div>");
    }
    out.println(" <div>");
    out.println("<button>등록</button>");
    out.println("</div>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int category = Integer.parseInt(request.getParameter("category"));
    String title = category == 1 ? "게시글" : "가입인사";

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang = 'en'>");
    out.println("<head>");
    out.println("   <meta charset = 'UTF-8'>");
    out.println("   <title> 비트캠프 데브옵스 5 기 </title>");
    out.println("</head>");
    out.println("<body>");
    request.getRequestDispatcher("/header").include(request, response);
    out.printf("<h1>%s</h1>", title);

    Board board = new Board();
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser != null) {
      board.setWriter(loginUser);
    } else {
      out.println("<p>로그인하시기 바랍니다.</p>");
      request.getRequestDispatcher("/footer").include(request, response);
      out.println("</body>");
      out.println("</html>");
      return;
    }
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setCategory(category);

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
    if (category == 1) {
      String[] files = request.getParameterValues("files");
      if (files != null) {
        for (String file : files) {
          if (file.length() == 0) {
            continue;
          }
          attachedFiles.add(new AttachedFile().filePath(file));
        }
      }
    }

    try {
      txManager.startTransaction();

      boardDao.add(board);

      if (attachedFiles.size() > 0) {
        // 첨부파일 객체에 게시글 번호 저장
        for (AttachedFile file : attachedFiles) {
          file.setBoardNo(board.getNo());
        }
        attachedFileDao.addAll(attachedFiles);
      }

      txManager.commit();

      response.sendRedirect("/board/list?category=" + category);
      return;

    } catch (Exception e) {
      out.println("<p>입력 중 오류 발생!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
    }
    request.getRequestDispatcher("/footer").include(request, response);
    out.println("</body>");
    out.println("</html>");
  }
}
