package com.dhf.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Integer id;

    private String userName;

    private String userPass;

    private String userPhone;

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

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPass, user.userPass) &&
                Objects.equals(userPhone, user.userPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPass, userPhone);
    }
}