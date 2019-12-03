package com.zza.crud.Model;


public class User {
    private String username; // 登录账号
    private String password; // 登录密码
    private String phnumber; //电话号码
    private String QQ;       //qq账号
    public User() {
    }
    public User(String username, String password, String phnumber,String QQ) {
        this.phnumber = phnumber;
        this.username = username;
        this.password = password;
        this.QQ = QQ;
    }
    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public String getQQ() {
        return QQ;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString(){
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phnumber=" + phnumber + '\''  +
                ",QQ="+ QQ +
                '}';
    }
}
