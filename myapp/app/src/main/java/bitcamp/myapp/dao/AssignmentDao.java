package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import java.util.List;

public class AssignmentDao extends AbstractDao<Assignment> {

  private static int index;
  private int lastNo = list.getLast().getNo();

  public AssignmentDao(String filepath) {
    super(filepath);
  }

  public void add(Assignment assignment) {
    assignment.setNo(++lastNo);
    list.add(assignment);
    saveData();
  }

  public int remove(int no) {
    index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  public List<Assignment> findAll() {
    return list.subList(0, list.size());
  }

  public Assignment findBy(int no) {
    index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Assignment assignment) {
    index = indexOf(assignment.getNo());
    if (index == -1) {
      return 0;
    }
    list.set(index, assignment);
    saveData();
    return 1;
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
