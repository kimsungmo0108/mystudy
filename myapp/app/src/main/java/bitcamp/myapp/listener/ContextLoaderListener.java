package bitcamp.myapp.listener;

import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  // 웹 애플리케이션이 사용할 자원을 준비시키고 해제시키는 역할

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("웹 애플리케이션 자원 준비!");
    
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");

    // 공유 객체를 보관할 맵 객체 준비
    Map<String, Object> beanMap = new HashMap<>();
    beanMap.put("connectionPool", connectionPool);
    beanMap.put("assignmentDao", new AssignmentDaoImpl(connectionPool));
    beanMap.put("memberDao", new MemberDaoImpl(connectionPool));
    beanMap.put("boardDao", new BoardDaoImpl(connectionPool));
    beanMap.put("txManager", new TransactionManager(connectionPool));
    beanMap.put("attachedFileDao", new AttachedFileDaoImpl(connectionPool));

    // 서블릿에서 사용할 수 있도록 웹 애플리케이션 저장소에 보관한다
    ServletContext 웹애플리케이션저장소 = sce.getServletContext();
    웹애플리케이션저장소.setAttribute("beanMap", beanMap);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("웹 애플리케이션 자원 해제!");
  }
}
