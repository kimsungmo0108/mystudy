package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    this.setValue(Date.valueOf(text)); // yyyy-mm-dd ===> java.sql.Date 객체로 변환
  }
}
