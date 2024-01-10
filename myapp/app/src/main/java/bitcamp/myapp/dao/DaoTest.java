package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Board;

public class DaoTest extends AbstractDao<Board> {

  public static void main(String[] args) {

    DaoTest obj = new DaoTest();
    obj.loadData("app/board.json");

    for (Board item : obj.list) {
      System.out.println(item);
    }

  }

}
