package bitcamp.myapp.menu;

// 메뉴를 처리하는 객채의 사용법을 정의한다.
public interface Menu {

  // 객체를 실행할 때 호출할 메소드를 선언한다
  // 구현을 해서는 안된다
  // => 추상 메소드
  public abstract void execute();

}
