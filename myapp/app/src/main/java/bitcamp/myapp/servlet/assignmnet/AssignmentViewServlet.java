package bitcamp.myapp.servlet.assignmnet;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/view")
public class AssignmentViewServlet extends HttpServlet {

  private AssignmentDao assignmentDao;

  @Override
  public void init() throws ServletException {
    this.assignmentDao = (AssignmentDaoImpl) this.getServletContext().getAttribute("assignmentDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang = 'en'>");
    out.println("<head>");
    out.println("   <meta charset = 'UTF-8'>");
    out.println("   <title> 비트캠프 데브옵스 5 기 </title>");
    out.println("</head>");
    try {
      out.println("<body>");
      request.getRequestDispatcher("/header").include(request, response);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    out.println("<h1>과제</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      Assignment assignment = assignmentDao.findBy(no);
      if (assignment == null) {
        out.println("<p>과제 번호가 유효하지 않습니다!</p>");
        request.getRequestDispatcher("/footer").include(request, response);
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.printf("<form action='/assignment/update' method='post'>\n");
      out.printf(" <div>\n");
      out.printf("  번호: <input readonly name = 'no' type = 'text' value='%s'>\n",
          assignment.getNo());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  제목: <input name = 'title' type = 'text' value='%s'>\n", assignment.getTitle());
      out.printf("  </div>\n");
      out.printf("  <div>\n");
      out.printf("  내용: <textarea name = 'content'>%s</textarea>\n", assignment.getContent());
      out.printf("  </div>\n");
      out.printf(" <div>\n");
      out.printf("  제출날짜: <input name='deadline' type = 'date' value='%s'>\n",
          assignment.getDeadline());
      out.printf("  </div>\n");
      out.printf("  <div>\n");
      out.printf("  <button>변경</button>");
      out.printf("  <a href='/assignment/delete?no=%d'>[삭제]</a>\n", no);
      out.printf("  </div>");

    } catch (Exception e) {
      out.println("<p>조회 오류! </p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    request.getRequestDispatcher("/footer").include(request, response);
    out.println("</body>");
    out.println("</html>");
  }
}
