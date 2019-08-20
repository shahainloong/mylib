package com.ac.mylib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author hailong.sha */
public class TopFineUtil {
  // spring官方提供的log写法
  private static final Logger logger = LoggerFactory.getLogger(TopFineUtil.class);

  public static final String COLON = ":";

  public static final String STORESERVICE = "StoreService";
  public static final String STORESERVICE_LOWERCASE = "storeservice";

  public static final String SALESERVICE = "SaleService";
  public static final String SALESERVICE_LOWERCASE = "saleservice";

  public static String getServerName(String serverName) {
    switch (serverName) {
      case TopFineUtil.STORESERVICE_LOWERCASE:
        return TopFineUtil.STORESERVICE;
      case TopFineUtil.SALESERVICE_LOWERCASE:
        return TopFineUtil.SALESERVICE;
      default:
        break;
    }
    return "Unknown Server";
  }

  public static String getLowerCase(String str) {
    return str.toLowerCase();
  }
  
  public static void main(String[] args) {
	System.out.println(getServerName("storeservice"));
}

  /** Utility classes should not have public constructors */
  private TopFineUtil() {
    super();
  }
}
