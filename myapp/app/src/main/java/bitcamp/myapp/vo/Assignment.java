package bitcamp.myapp.vo;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

public class Assignment implements Serializable {

  @Serial
  private static final long serialVersionUID = 100L;
  private int no;
  private String title;
  private String content;
  private Date deadline;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  // 팩토리 메소드

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  @Override
  public String toString() {
    return "Assignment{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", deadline=" + deadline +
        '}';
  }
}
