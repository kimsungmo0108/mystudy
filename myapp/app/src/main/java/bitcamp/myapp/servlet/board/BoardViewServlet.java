package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {

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
    out.printf("<h1>%s</h1>\n", title);

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("<p>번호가 유효하지 않습니다.</p>");
        request.getRequestDispatcher("/footer").include(request, response);
        out.println("</body>");
        out.println("</html>");
        return;
      }

      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
      out.printf("<form action='/board/update' method='post'>\n");
      out.printf(" <div>\n");
      out.printf("<input readonly name='category' type='hidden' value=%d>\n", category);
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  번호: <input readonly name = 'no' type = 'text' value='%s'>\n", board.getNo());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  제목: <input name = 'title' type = 'text' value='%s'>\n", board.getTitle());
      out.printf("  </div>\n");
      out.printf("  <div>\n");
      out.printf("  내용: <textarea name = 'content'>%s</textarea>\n", board.getContent());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  작성자: <input readonly type = 'text' value='%s'>\n", board.getWriter().getName());
      out.printf("  </div>\n");

      if (category == 1) {
        out.printf("  <div>\n");
        out.printf("  첨부파일: <input multiple name = 'files' type = 'file'>\n");
        out.printf("  <ul>\n");
        for (AttachedFile file : files) {
          out.printf("    <li>%s <a href='/board/file/delete?no=%d'>삭제</a></li>\n",
              file.getFilePath(),
              file.getNo());
        }
        out.printf("  </ul>\n");
        out.printf("  </div>\n");
      }
      out.printf("  <div>\n");
      out.printf("  <button> 변경 </button>");
      out.printf("  <a href='/board/delete?no=%d&category=%d'>[삭제]</a>\n", no, category);
      out.printf("  </div>\n");
      out.printf("</form>\n");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    request.getRequestDispatcher("/footer").include(request, response);
    out.println("</body>");
    out.println("</html>");
  }
}
