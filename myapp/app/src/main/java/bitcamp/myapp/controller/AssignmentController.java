package bitcamp.myapp.controller;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AssignmentController {

  private AssignmentDao assignmentDao;

  public AssignmentController(AssignmentDao assignmentDao) {
    this.assignmentDao = assignmentDao;
  }

  @RequestMapping("/assignment/add")
  public String add(HttpServletRequest request)
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

  @RequestMapping("/assignment/list")
  public String list(HttpServletRequest request)
      throws ServletException, IOException {
    request.setAttribute("list", assignmentDao.findAll());

    return "/assignment/list.jsp";
  }


  @RequestMapping("/assignment/view")
  public String view(@RequestParam("no") int no, HttpServletRequest request)
      throws Exception {
    Assignment assignment = assignmentDao.findBy(no);
    if (assignment == null) {
      throw new Exception("과제 번호가 유효하지 않습니다!");
    }

    request.setAttribute("assignment", assignment);
    return "/assignment/view.jsp";
  }

  @RequestMapping("/assignment/update")
  public String update(HttpServletRequest request)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Assignment old = assignmentDao.findBy(no);
    if (old == null) {
      throw new Exception("과제 번호가 유효하지 않습니다.");
    }

    Assignment assignment = new Assignment();
    assignment.setNo(old.getNo());
    assignment.setTitle(request.getParameter("title"));
    assignment.setContent(request.getParameter("content"));
    assignment.setDeadline(Date.valueOf(request.getParameter("deadline")));

    assignmentDao.update(assignment);

    return "redirect:list";
  }

  @RequestMapping("/assignment/delete")
  public String delete(HttpServletRequest request)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    if (assignmentDao.delete(no) == 0) {
      throw new Exception("과제 번호가 유효하지 않습니다.");
    }

    return "redirect:list";
  }

}