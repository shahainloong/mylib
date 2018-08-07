package com.ac.mylib.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * 学习java8时候准备的公共类
 *
 * @author hailong.sha
 */
public class OptionalUtility {
    /**
     * spring官方提供的log写法
     */
    private static final Logger logger = LoggerFactory.getLogger(OptionalUtility.class);

  /**
   * 通过这种方式，你以后就能直接调用OptionalUtility.stringToInt方法，将
   * String转换为一个Optional<Integer>对象，而不再需要记得你在其中封装了笨拙的 try/catch的逻辑了
   *
   * @param s
   * @return
   */
  public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
