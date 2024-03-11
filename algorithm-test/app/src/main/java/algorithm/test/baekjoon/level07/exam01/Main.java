package algorithm.test.baekjoon.level07.exam01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    String text = "#한글 #Java #한글 #한글 #한글";

    // 정규 표현식을 사용하여 해시 태그 추출 (한글 포함)
    Pattern pattern = Pattern.compile("#[\\w가-힣]+");
    Matcher matcher = pattern.matcher(text);

    // 매칭된 해시 태그 출력
    while (matcher.find()) {
      String hashtag = matcher.group();
      System.out.println("Hashtag: " + hashtag);
    }
  }
}
