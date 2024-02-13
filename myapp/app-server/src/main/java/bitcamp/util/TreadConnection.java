package bitcamp.util;

import java.sql.Connection;

public class TreadConnection {

  String jdbcUrl;
  String username;
  String password;

  // 스레드 전용 커넥선 저장소
  ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

  public TreadConnection(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection get() {
    Connection con = connectionThreadLocal.get();
    if (con == null) {
//      Connection con = DriverManager.getConnection(jdbcUrl, username, password);
    }
    return con;
  }

}
