package bitcamp.myapp.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;


}
