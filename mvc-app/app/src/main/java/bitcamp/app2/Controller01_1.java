package bitcamp.app2;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c01_1")
public class Controller01_1 {
  @GetMapping("h1")
  // @ResponseBody // 뷰 이름을 리턴 할 때는 이 애노테이션을 붙이면 안된다.
  public String handler1(Model model) {

    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);

    return "/jsp/c01_1.jsp";
    // 기본 ViewResolver는 리턴 값으로 받은 view name으로 JSP를 찾는다
    // 1) 절대 경로로 시작할 때 '/'로 시작할 때
    //   예) return "/jsp/c01_1.jsp";
    //       view URL = /웹애플리케이션루트경로 + view name
    //                = /jsp/c01_1.jsp
    //
    // 2) 상대 경로로 시작할 때 '/'로 시작하지 않을 때
    //   예) return "jsp/c01_1.jsp";
    //       view URL = 현재 URL 경로 + view name
    //                = /웹애플리케이션경로/app2/c01_1 + jsp/c01_1.jsp
    //                = /웹애플리케이션경로/app2/c01_1/jsp/c01_1.jsp
    //
    //
    // 즉 view name을 JSP URL로 간주한다
    // 따라서 위의 return 문의 view name은 다음 JSP 경로와 같다
    // JSP 경로는 다음과 같다.
    // ==> /컨텍스트경로/jsp/c01_1.jsp
    //
    // InternalResourceViewResolver로 교체한 다음의 JSP URL은?
    // => /WEB-INF/jsp2//jsp/c01_1.jsp.jsp
  }

  @GetMapping("h2")
  public void handler2(Model model) {
    model.addAttribute("name", "홍길동2");
    model.addAttribute("age", 30);

    // 뷰 이름을 리턴하지 않으면,
    // request handler의 URL을 상대 경로 view name으로 사용한다
    // return "c01_1/h2";
    // 계산방법:
    // => 현재 URL = /app2/c01_1
    // => view URL = 현재 URL + request handler URL
    //             = /app2/c01_1 + c01_1/h2
    //             = /app2/c01_1/c01_1/h2
    //     따라서 잘못 계산된 view URL로 JSP를 찾으니까 오류 발생!
    //
    // InternalResourceViewResolver로 교체한 다음은?
    // => 리턴 값이 없으면 요청 URL(c01_1/h2)을 리턴 값으로 사용한다.
    // => 따라서 ViewResolver가 계산한 최종 URL은
    // /WEB-INF/jsp2/c01_1/h2.jsp
    //

  }
}
