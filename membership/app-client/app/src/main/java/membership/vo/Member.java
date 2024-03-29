package membership.vo;

import java.io.Serial;
import java.io.Serializable;

import java.sql.Time;
import java.util.Date;


public class Member implements Serializable {

  @Serial
  private static final long serialVersionUID = 100L;
  private int no;
  private String email;
  private String name;
  private String password;
  private String addr;
  private String tel;
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  private Date createdDate;
  private Time createdTime;

  @Override
  public String toString() {
    return "Member{" +
        "no=" + no +
        ", email='" + email + '\'' +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", addr='" + addr + '\'' +
        ", tel='" + tel + '\'' +
        ", id='" + id + '\'' +
        ", createdDate=" + createdDate +
        ", createdTime=" + createdTime +
        '}';
  }

  public Time getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Time createdTime) {
    this.createdTime = createdTime;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }
}
