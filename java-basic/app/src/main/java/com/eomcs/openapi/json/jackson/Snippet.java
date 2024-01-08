package com.eomcs.openapi.json.jackson;

public class Snippet {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = ("Asia/Seoul"))
    private Date startDate;
}

