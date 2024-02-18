package bitcamp.myapp.servlet.assignmnet;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/delete")
public class AssignmentDeleteServlet extends HttpServlet {

  private AssignmentDao assignmentDao;

  public AssignmentDeleteServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.assignmentDao = new AssignmentDaoImpl(connectionPool);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html lang = 'en'>");
    out.println("<head>");
    out.println("   <meta charset = 'UTF-8'>");
    out.println("   <title> 비트캠프 데브옵스 5 기 </title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>과제</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      assignmentDao.delete(no);
      out.println("<p>과제를 삭제했습니다.</p>");

    } catch (Exception e) {
      out.println("<p>등록 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
