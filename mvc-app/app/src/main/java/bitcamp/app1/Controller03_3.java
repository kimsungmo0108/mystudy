// request handler를 구분하는 방법 - Accept 요청 헤더의 값에 따라 구분하기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_3")
public class Controller03_3 {

  @GetMapping("text")
  @ResponseBody
  public String text() {
    return "text";
  }
  @GetMapping("html")
  @ResponseBody
  public String html() {
    return "<html><body><h1>text</h1></body></html>";
  }
  @GetMapping("json")
  @ResponseBody
  public String json() {
    return "{\"name\":\"title\"}";
  }

  // 테스트 방법:
  // => http://localhost:9999/eomcs-spring-webmvc/html/app1/c03_3.html
  // => 요청 헤더 중에서 Accept의 값에 따라 구분할 때 사용한다.
  //
  // Accept 헤더?
  // => HTTP 클라이언트(웹 브라우저)에서 서버에 요청할 때
  //    받고자 하는 콘텐트의 타입을 알려준다.

  @GetMapping(produces = "text/plain")
  @ResponseBody
  public String handler1() {
    return "text";
  }

  @GetMapping(produces = "text/html")
  @ResponseBody
  public String handler2() {
    return "<html><body><h1>text</h1></body></html>";
  }

  @GetMapping(produces = "application/json")
  @ResponseBody
  public String handler3() {
    return "{\"name\":\"title\"}";
  }

  @GetMapping(produces = "text/csv")
  @ResponseBody
  public String handler4() {
    return "1,hong,20,female";
  }

  @GetMapping
  @ResponseBody
  public String handler5() {
    return "other...";
  }
}
