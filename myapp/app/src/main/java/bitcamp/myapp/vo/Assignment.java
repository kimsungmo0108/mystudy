package bitcamp.myapp.vo;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

public class Assignment implements Serializable, CsvString {

  @Serial
  private static final long serialVersionUID = 100L;

  private String title;
  private String content;
  private Date deadline;

  // 팩토리 메소드
  public static Assignment createFromCsv(String csv) {
    String[] valus = csv.split(",");
    Assignment obj = new Assignment();
    obj.setTitle(valus[0]);
    obj.setContent(valus[1]);
    obj.setDeadline(Date.valueOf(valus[2]));
    return obj;
  }
//  public void createFromCsv(String csv) {
//    String[] valus = csv.split(",");
//
////    this.title = valus[0];
////    this.content = valus[1];
////    this.deadline = Date.valueOf(valus[2]);
//    setTitle(valus[0]);
//    setContent(valus[1]);
//    setDeadline(Date.valueOf(valus[2]));
//  }

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
  public String toCsvString() {
    return String.format("%s,%s,%s", this.title, this.content, this.deadline);
  }
}
