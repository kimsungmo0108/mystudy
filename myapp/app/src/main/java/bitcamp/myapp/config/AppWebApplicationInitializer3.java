package bitcamp.myapp.config;


import java.io.File;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

public class AppWebApplicationInitializer3 /*extends AbstractDispatcherServletInitializer*/ {

  ServletContext servletContext;
  AnnotationConfigWebApplicationContext rootContext;


  //  @Override
  protected WebApplicationContext createRootApplicationContext() {
    rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(RootConfig.class);
    rootContext.refresh();
    return rootContext;
  }

  //  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    appContext.setParent(rootContext);
    appContext.setServletContext(servletContext);
    appContext.refresh();
    return appContext;
  }

  //  @Override
  protected String[] getServletMappings() {
    return new String[]{"/app/*"};
  }

  //  @Override
  protected void customizeRegistration(Dynamic registration) {
    registration.setMultipartConfig(
        new MultipartConfigElement(
            new File("./temp").getAbsolutePath(),
            //new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
            1024 * 1024 * 10,
            1024 * 1024 * 100,
            1024 * 1024 * 1));
  }

  //  @Override
  protected Filter[] getServletFilters() {
    return new Filter[]{new CharacterEncodingFilter("UTF-8")};
  }

  //  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // 수퍼 클래스에 onStartup()에서 ContextLoaderListener를 생성하기 때문에
    // 기존의 기능을 그대로 수행하도록 수퍼 클래스의 메소드를 호출한다
    this.servletContext = servletContext;
//    super.onStartup(servletContext);
  }
}
