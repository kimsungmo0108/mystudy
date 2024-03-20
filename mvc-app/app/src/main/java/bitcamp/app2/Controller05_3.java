package bitcamp.app2;

import java.net.URLDecoder;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c05_3")
public class Controller05_3 {
  @RequestMapping(value="h1", produces="text/plain;charset=UTF-8")
  public Object handler1(
      int no,
      String title,
      String writer,
      int viewCount) {

    return String.format("%d,%s,%s,%d", no, title, writer, viewCount);
  }

  @RequestMapping(value="h2", produces="text/plain;charset=UTF-8")
  public Object handler2(Board board) {
    return board.toString();
  }

  @RequestMapping(value="h3", produces="text/plain;charset=UTF-8")
  public Object handler3(@RequestBody String content) throws Exception {
    System.out.println(content);
    System.out.println(URLDecoder.decode(content, "UTF-8"));
    return "OK!";
  }

  @RequestMapping(value="h4", produces="text/plain;charset=UTF-8")
  public Object handler4(@RequestBody Map<String,Object> content) throws Exception {
    System.out.println(content);
    return "OK!";
  }

  @RequestMapping(value="h5", produces="text/plain;charset=UTF-8")
  public Object handler5(@RequestBody Board content) throws Exception {
    System.out.println(content);

    // 주의!
    // => 클라이언트에서 보낸 날짜 데이터의 문자열 형식이 yyyy-MM-dd 형태여야 한다.
    //    그래야 java.util.Date 타입의 값으로 변환해 준다.
    //    예) 2019-05-01 ===> java.util.Date 객체 변환 성공!
    // => 만약 이 형태가 아니면 변환할 수 없어 실행 오류가 발생한다.
    //    예) 05/01/2020 또는 2020-5-1 ===> 변환 오류!
    //
    // @JsonFormat 애노테이션 사용
    // => 이 애노테이션은 MappingJackson2HttpMessageConverter를 위한 것이다.
    //    GsonHttpMessageConverter는 이 애노테이션을 인식하지 않는다.
    // => 도메인 객체의 프로퍼티에 이 애노테이션을 붙이면
    //    2019-05-01 이나 2019-5-1 모두 처리할 수 있다.
    // => 뿐만 아니라, 도메인 객체를 JSON 문자열로 변환할 때도
    //    해당 형식으로 변환된다.
    //

    return "OK!";
  }
}
