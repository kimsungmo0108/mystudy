package com.eomcs.openapi.json.jackson;

import java.sql.Date;

public class Member {
  private int no;
  private String name;
  private String email;
  private String password;
  private String photo;
  private String tel;

  // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = ("Asia/Seoul"))
  private Date registeredDate;

  private School school;

  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }



  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
        + ", photo=" + photo + ", tel=" + tel + ", registeredDate=" + registeredDate + ", school="
        + school + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
}
