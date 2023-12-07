package bitcamp.util;

public class AnsiEscape {

  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  public static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR + "\n";
  static final String ANSI_RED = "\033[0;31m";
  public static final String MENU4 = ANSI_RED + "0. 종료" + ANSI_CLEAR;
}
