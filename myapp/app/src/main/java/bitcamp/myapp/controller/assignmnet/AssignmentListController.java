package bitcamp.myapp.controller.assignmnet;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.AssignmentDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AssignmentListController implements PageController {


  private AssignmentDao assignmentDao;


  public AssignmentListController(AssignmentDao assignmentDao) {
    this.assignmentDao = assignmentDao;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("list", assignmentDao.findAll());

    return "/assignment/list.jsp";

  }
}