package com.shiromanager.account.bean;

/**
 * Created with IntelliJ IDEA.
 * User: john
 * Date: 1/18/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String usercode;
    private String userName;
    private String password;

    public String getUsercode() {
        return usercode;
    }
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
