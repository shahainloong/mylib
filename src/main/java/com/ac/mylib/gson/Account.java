package com.ac.mylib.gson;

/**
 * 说明：GSON所有的用法都基于Account类！
 *
 * @author hailog.sha
 */
public class Account {

    private String uid;
    private String userName;
    private String password;
    private String telNumber;

    public Account(String uid, String userName, String telNumber) {
        this.uid = uid;
        this.userName = userName;
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Account [uid=" + uid + ", userName=" + userName + ", password=" + password + ", telNumber=" + telNumber
                + "]";
    }
}
