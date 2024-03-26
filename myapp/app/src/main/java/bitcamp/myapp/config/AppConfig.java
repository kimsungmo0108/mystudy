package bitcamp.myapp.config;

import java.nio.charset.StandardCharsets;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@ComponentScan({"bitcamp.myapp.controller"})
public class AppConfig {

  private final Log log = LogFactory.getLog(this.getClass());

  public AppConfig() {
    log.debug("생성자 호출됨!");
  }

  @Bean
  public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/jsp/");
//    viewResolver.setSuffix(".jsp");
    viewResolver.setViewNames("*.jsp");
    viewResolver.setOrder(1);
    return viewResolver;
  }

  @Bean
  public ThymeleafViewResolver thymeleafViewResolver(ISpringTemplateEngine springTemplateEngine) {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(springTemplateEngine);
    viewResolver.setViewNames(new String[]{"*.html", "*.xhtml", "*"});
    viewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    viewResolver.setOrder(2);
    return viewResolver;
  }

  @Bean
  public SpringResourceTemplateResolver templateResolver(ApplicationContext applicationContext) {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setApplicationContext(applicationContext);
    templateResolver.setPrefix("/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);

    // HTML 템플릿을 Thymeleaf 엔진이 사용할 수 있도록
    // 특정 형식에 맞춰 컴파일 해 둘 것인가?
    // => 컴파일? 어떤 형식의 데이터를 다른 형식의 데이터로 바꾸는 것도 컴파일이다
    // => 개발하는 동안 템플릿 파일의 내용을 자주 바꿀 수 있기 때문에
    //    실행할 때마다 템플릿 파일을 컴파일 하는 것이 좋다
    //    컴파일한 것을 보관해두면 템플릿 파일을 변경하더라도 다시 컴파일하지 않는다
    //    왜? 템플릿 파일을 변경할 때마다 서버를 다시 싱행해야 하기 때문이다
    // => 개발이 완료된 다음에는 템플릿 파일을 컴파일한 결과를 보관해 두는 것이
    //    실행 속도를 높힌다
    templateResolver.setCacheable(false);
    return templateResolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
    templateEngine.setEnableSpringELCompiler(true);
    return templateEngine;
  }
}