package bitcamp.myapp.vo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {

  @Serial
  private static final long serialVersionUID = 100L;
  private String title;
  private String content;
  private String writer;
  private Date createdDate;

  public static Board createFromCsv(String csv) {
    String[] valus = csv.split(",");
    Board obj = new Board();
    obj.setTitle(valus[0]);
    obj.setContent(valus[1]);
    obj.setWriter(valus[2]);
    obj.setCreatedDate(new Date(Long.valueOf(valus[3])));
    return obj;
  }

  @Override
  public String toString() {
    return "Board{" +
        "title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", writer='" + writer + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

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

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
