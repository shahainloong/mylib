package com.ac.mylib.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Echo
 */
@Data
public class Diary {
    private int id = 0;// 日记ID号
    private String title = "";// 日记标题
    private String address = "";// 日记图片地址
    private Date writeTime = null;// 写日记的时间
    private int userid = 0;// 用户ID
    private String username = "";// 用户名



}

