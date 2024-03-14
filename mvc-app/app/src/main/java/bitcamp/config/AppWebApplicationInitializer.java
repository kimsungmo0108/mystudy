package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebApplicationInitializerImpl extends AbstractDispatcherServletInitializer {

  private static Log log = LogFactory.getLog(WebApplicationInitializerImpl.class);
  AnnotationConfigWebApplicationContext rootContext;

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(RootConfig.class);
    rootContext.refresh();
    return rootContext;
  }


  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.setParent(rootContext);
    appContext.register(AppConfig.class);
    appContext.refresh();
    return  appContext;
  }
  @Override
  protected String[] getServletMappings() {
    return new String[]{"/app/*"};
  }

  @Override
  protected String getServletName() {
    return "app";
  }

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    log.debug("onStartup() 호출됨!");
    
    // 수퍼 클래스의 구현 내용은 그대로 유지해야한다
    // 왜? 수퍼 클래스의 메소드에서 ContextLoaderListener 객체를 만들기 때문이다
    super.onStartup(servletContext);

    AnnotationConfigWebApplicationContext adminContext = new AnnotationConfigWebApplicationContext();
    adminContext.setParent(rootContext);
    adminContext.register(AdminConfig.class);
    adminContext.refresh();
    Dynamic adminServletRegistration = servletContext.addServlet("admin",
        new DispatcherServlet(adminContext));
    adminServletRegistration.addMapping("/admin/*");
    adminServletRegistration.setLoadOnStartup(1);
  }

}
