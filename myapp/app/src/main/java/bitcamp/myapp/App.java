package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    // 코드를 기능 단위로 묶어 메소드로 정의하면
    // 메소드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
    MainMenu.execute();
    Prompt.close();
  }
}