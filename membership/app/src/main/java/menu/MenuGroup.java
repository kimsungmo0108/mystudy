package menu;

import util.Prompt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Composite 패턴에서 '복합 객체(composite object)' 역할을 하는 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private List<Menu> menus = new LinkedList<>();

  private MenuGroup(String title) {
    super(title);
  }

  // GoF의 Factory Method 디자인 패턴git
  public static MenuGroup getInstance(String title) {
    return new MenuGroup(title);
  }

  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의하겠다고 컴파일러에게 알린다.
  public void execute(Prompt prompt) {
    // 메뉴를 실행할 때 메뉴의 제목을 breadcrumb에 경로를 추가한다
    prompt.pushPath(this.title);
    this.printMenu(prompt);

    while (true) {
      String input = prompt.input("%s> ", prompt.getFullPath());

      if (input.equals("menu")) {
        this.printMenu(prompt);
        continue;
      } else if (input.equals("0")) {
        break;
      }
      try {
        int menuNo = Integer.parseInt(input);
        if (menuNo < 1 || menuNo > this.menus.size()) {
          prompt.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }

        this.menus.get(menuNo - 1).execute(prompt);
      } catch (Exception e) {
        prompt.println("메뉴가 옳지 않습니다!");
      }
    }
    // 메뉴를 나갈 때 breadcrumb 메뉴 경로에서 메뉴 제목을 제거한다
    prompt.popPath();
  }

  private void printMenu(Prompt prompt) {
    prompt.printf("[%s]\n", this.getTitle());

    Iterator<Menu> iterator = this.menus.iterator();
    int i = 1;
    while (iterator.hasNext()) {
      Menu menu = iterator.next();
      prompt.printf("%d. %s\n", i++, menu.getTitle());
    }

    prompt.printf("0. %s\n", "이전");
  }


  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public MenuItem addItem(String title, MenuHandler handler) {
    MenuItem menuItem = new MenuItem(title, handler);
    this.add(menuItem);
    return menuItem;
  }

  public MenuGroup addGroup(String title) {
    MenuGroup menuGroup = new MenuGroup(title);
    this.add(menuGroup);
    return menuGroup;
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }
}
