package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import java.util.List;

public interface AssignmentDao {


  public void add(Assignment assignment);

  public int remove(int no);

  public List<Assignment> findAll();

  public Assignment findBy(int no);

  public int update(Assignment assignment);

}
