package algorithm.test.baekjoon.level06.exam02;

import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());
    printPath(dir, 1);
  }

  public static void printPath(File dir, int level) {
    File[] files = dir.listFiles();


    for (File file : files) {
      for (int i = 0; i < level; i++) {
        System.out.print("  ");
      }
      if (file.isDirectory() && !file.isHidden()) {
        System.out.println(file.getName() + "/");
        printPath(file, level + 1);
      } else if (file.isFile()) {
        System.out.println(file.getName());
      }

    }
  }
}


