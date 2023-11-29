public class Test4 {

  public static void main(String[] args) {

    String ANSI_CLEAR = "\033[0m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_RED = "\033[0;31m";
    String appTitle = "[과제관리 시스템]";
    String menu1 = "1. 과제", menu2 = "2. 게시글", menu3 = "3. 도움말", menu4 = "4. 종료";

    System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
    System.out.println();
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);

    java.util.Scanner numScan = new java.util.Scanner(System.in);
    menuloop: while (true) {
      // java.util.Scanner numScan = new java.util.Scanner(System.in);
      System.out.print("메뉴 번호를 눌러 주세요. : ");
      int num = numScan.nextInt();
      // System.out.println(num);
      switch (num) {
        case 1:
          System.out.println("1. 과제 메뉴를 선택하셨습니다.\n");
          continue;
        case 2:
          System.out.println("2. 게시글 메뉴를 선택하셨습니다.\n");
          continue;
        case 3:
          System.out.println("3. 도움말 메뉴를 선택하셨습니다.\n");
          continue;
        case 4:
          System.out.println("4. 종료 메뉴를 선택하셨습니다.\n");
          break menuloop;

      }
      numScan.close();
    }
  }
}
