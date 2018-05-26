package xyz.northsky.shop.dto;

import java.io.Serializable;
import java.util.Date;

public class UserCondition implements Serializable {

    private String userName;

    private String userGender;

    private Date userBirth;

    private String userTel;

    @Override
    public String toString() {
        return "UserCondition{" +
                "userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userBirth=" + userBirth +
                ", userTel='" + userTel + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
