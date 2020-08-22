package com.dhf.model;

import java.io.Serializable;

public class UserData implements Serializable {
    private Integer id;

    private String userName;

    private String userPhone;

    private String userPhoto;

    private Integer fans;

    private Integer noricer;

    private Integer notesNum;

    private Integer age;

    private String sex;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getNoricer() {
        return noricer;
    }

    public void setNoricer(Integer noricer) {
        this.noricer = noricer;
    }

    public Integer getNotesNum() {
        return notesNum;
    }

    public void setNotesNum(Integer notesNum) {
        this.notesNum = notesNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", fans=" + fans +
                ", noricer=" + noricer +
                ", notesNum=" + notesNum +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}