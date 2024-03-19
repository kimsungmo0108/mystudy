package bitcamp.app2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c01_2")
public class Controller01_2 {

  @GetMapping("h1")
  public String handler1(Model model) {

    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);

    return "c01_1";
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
    // request handler의 URL을 상대 경로로써 view name으로 사용한다
    // return "c01_1/h2";
    // 계산방법:
    // => "/WEB-INF/jsp2/" + "c01_2/h2" + ".jsp"
    // => "/WEB-INF/jsp2/c01_2/h2.jsp"
    //     따라서 잘못 계산된 view URL로 JSP를 찾으니까 오류 발생!
    // 실무에서는 이 방법을 많이 사용한다
  }

  @GetMapping("h3")
  public Map<String, Object> handler3() {

    HashMap<String, Object> map = new HashMap<>();
    map.put("name", "홍길동3");
    map.put("age", 40);

    // Map 객체에 값을 담아 리턴하면
    // 프론트 컨트롤러는 Map 객체에 보관되어 있는 값들을 ServletRequest 보관소로 옮긴다.
    // 그리고 view URL은 request handler의 URL을 사용한다.
    // => "/WEB-INF/jsp2/" + "c01_2/h3" + ".jsp" = "/WEB-INF/jsp2/c01_2/h3.jsp"
    return map;
  }
  @GetMapping("h4")
  public ModelAndView handler4() {

    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동3");
    mv.addObject("age", 40);
    mv.setViewName("c01_2/h4");

    // ModelAndView 객체에 값과 뷰 이름을 담아 리턴하면
    // 프론트 컨트롤러는 ModelAndView 객체에 보관되어 있는 값들을
    // ServletRequest 보관소로 옮기고,
    // 설정된 뷰 이름을 ViewResolver에게 넘긴다.
    //
    return mv;
  }

  @GetMapping("h5")
  public ModelAndView handler5() {

    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동3");
    mv.addObject("age", 40);

    // ModelAndView 객체에 값과 뷰 이름을 담아 리턴하면
    // 프론트 컨트롤러는 ModelAndView 객체에 보관되어 있는 값들을
    // ServletRequest 보관소로 옮기고,
    // 뷰 이름을 지정하지 않으면 request handler의 path를 ViewResolver에게 넘긴다.
    // => c01_2/h5
    // InternalResourceViewResolver 는 위 URL을 다음과 같이 바꾼다.
    // => /WEB-INF/jsp2/c01_2/h5.jsp
    // 그런 후에 해당 URL의 JSP를 실행한다.
    return mv;
  }
}


