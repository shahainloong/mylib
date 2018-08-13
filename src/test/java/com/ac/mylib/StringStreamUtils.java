package com.ac.mylib;

import java.io.*;

/** @Author: @Date: 2018/8/6 16:27 @Version 1.0 */
public class StringStreamUtils {

  // json转String
  public static String json2String(String path) throws IOException {
    StringBuilder result = new StringBuilder();
    InputStream in = new FileInputStream(path);
    // 读取文件上的数据。
    // 将字节流向字符流的转换。
    InputStreamReader isr = new InputStreamReader(in, "UTF-8"); // 读取
    // 创建字符流缓冲区
    BufferedReader bufr = new BufferedReader(isr); // 缓冲

    String line = null;
    while ((line = bufr.readLine()) != null) {
      // result.append(System.lineSeparator()+line);
      result.append(line);
    }
    isr.close();
    return result.toString();
  }

//  /**
//   * 在需要调用的地方使用以下语句，其中xxx.json在resources目录下面
//   *
//   * @param args
//   */
//  public static void main(String[] args) {
//    //
//    String path = this.getClass().getClassLoader().getResource("xxx.json").getPath();
//
//    String str = StringStreamUtils.json2String(path);
//  }
}
