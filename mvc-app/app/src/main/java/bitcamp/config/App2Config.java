package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("bitcamp.app2")
public class App2Config {
  @Bean
  public ViewResolver viewResolver(){
    InternalResourceViewResolver vr = new InternalResourceViewResolver(
        "/WEB-INF/jsp2/",
        ".jsp"
    );
    return vr;
  }

}
