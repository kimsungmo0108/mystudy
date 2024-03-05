package bitcamp.myapp.controller.assignmnet;

import bitcamp.myapp.controller.RequestMapping;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AssignmentAddController {

  private AssignmentDao assignmentDao;


  public AssignmentAddController(AssignmentDao assignmentDao) {
    this.assignmentDao = assignmentDao;
  }


  @RequestMapping
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getMethod().equals("GET")) {
      return "/assignment/form.jsp";
    }

    Assignment assignment = new Assignment();
    assignment.setTitle(request.getParameter("title"));
    assignment.setContent(request.getParameter("content"));
    assignment.setDeadline(Date.valueOf(request.getParameter("deadline")));
    assignmentDao.add(assignment);

    return "redirect:list";


  }
}
