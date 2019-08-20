package com.ac.mylib.topfine;

import java.util.ArrayList;
import java.util.List;

import com.ac.mylib.util.TopFineUtil;

public class RedisKeyGenerator {
  private String reqAdd = "storeservice/shichang/week_year/310101";
  //  week_year
  //  mth_year
  //  season_year
  //  dw_year

  public static final String SERVICE_NAME_SALESERVICE = "saleservice";
  public static final String SERVICE_NAME_STORESERVICE = "storeservice";
  public static final String METHOD_NAME_MACD = "MACD";
  public static final String METHOD_NAME_MARKETRANK2 = "marketRank2";
  public static final String PARAM_NAME_1 = "310101";
  public static final String PARAM_NAME_2 = "week_year";
  public static final String PARAM_NAME_3 = "201819";

  public static final String REDIS_KEYS = "keys ";
  public static final String REDIS_DEL = "del ";

  public static void main(String[] args) {

    List<String> timeAllType = new ArrayList<>();
    timeAllType.add("week_year");
    timeAllType.add("mth_year");
    timeAllType.add("season_year");
    timeAllType.add("dw_year");
    List<String> param3 = new ArrayList<>();
    param3.add("201819");
    param3.add("2018-04");
    param3.add("20181");
    param3.add("2017");
    List<String> cigaretteNo = new ArrayList<>();
    cigaretteNo.add("310101");
    cigaretteNo.add("1007");
    cigaretteNo.add("1008");
    cigaretteNo.add("1009");
    cigaretteNo.add("1011");
//    cigaretteNo.add("310205");
//    cigaretteNo.add("310206");
//    cigaretteNo.add("310207");
//    cigaretteNo.add("310219");
//    cigaretteNo.add("310224");
//    cigaretteNo.add("310229");
//    cigaretteNo.add("310240");
//    cigaretteNo.add("310243");
//    cigaretteNo.add("310245");
//    cigaretteNo.add("310248");
//    cigaretteNo.add("310301");
//    cigaretteNo.add("310303");
//    cigaretteNo.add("310303");
//    cigaretteNo.add("310901");
//    cigaretteNo.add("310902");
//    cigaretteNo.add("310903");
//    cigaretteNo.add("320503");
//    cigaretteNo.add("320505");
//    cigaretteNo.add("322602");
//    cigaretteNo.add("330403");
//    cigaretteNo.add("330407");
//    cigaretteNo.add("330409");
//    cigaretteNo.add("330411");
//    cigaretteNo.add("330417");
//    cigaretteNo.add("340108");
//    cigaretteNo.add("340120");
//    cigaretteNo.add("340124");
//    cigaretteNo.add("370605");
//    cigaretteNo.add("372203");
//    cigaretteNo.add("410606");
//    cigaretteNo.add("410806");
//    cigaretteNo.add("423801");
//    cigaretteNo.add("423802");
//    cigaretteNo.add("423806");
//    cigaretteNo.add("423807");
//    cigaretteNo.add("430102");
//    cigaretteNo.add("430113");
//    cigaretteNo.add("430402");
//    cigaretteNo.add("430407");
//    cigaretteNo.add("520101");
//    cigaretteNo.add("520105");
//    cigaretteNo.add("530108");
//    cigaretteNo.add("530109");
//    cigaretteNo.add("530503");
//    cigaretteNo.add("530613");
//    cigaretteNo.add("530904");
//    cigaretteNo.add("530907");

    for (String str : cigaretteNo) {
    	for (int i = 0; i < timeAllType.size(); i++) {
    		  String timeType = timeAllType.get(i);
    		  StringBuilder keyName = new StringBuilder();
    	      keyName.append(RedisKeyGenerator.REDIS_DEL);
    	      keyName
    	          .append(TopFineUtil.getServerName(SERVICE_NAME_SALESERVICE))
    	          .append(TopFineUtil.COLON)
    	          .append(RedisKeyGenerator.METHOD_NAME_MACD)
    	          .append(TopFineUtil.COLON)
    	          .append(str)
    	          .append(TopFineUtil.COLON)
    	          .append(timeType);
    	      
    	      StringBuilder delKeyName = new StringBuilder();
    	      delKeyName.append(RedisKeyGenerator.REDIS_DEL);
    	      delKeyName
    	          .append(TopFineUtil.getServerName(SERVICE_NAME_STORESERVICE))
    	          .append(TopFineUtil.COLON)
    	          .append(RedisKeyGenerator.METHOD_NAME_MARKETRANK2)
    	          .append(TopFineUtil.COLON)
    	          .append(str)
    	          .append(TopFineUtil.COLON)
    	          .append(timeType);
    	      if (!"".equals(RedisKeyGenerator.PARAM_NAME_3)) {
    	    	  delKeyName.append(TopFineUtil.COLON).append(param3.get(i));
    	      }
    	      System.out.println(keyName);
    		  
    	  }
    	    for (int i = 0; i < timeAllType.size(); i++) {
    	  	  String timeType = timeAllType.get(i);
    	  	  StringBuilder keyName = new StringBuilder();
    	        keyName.append(RedisKeyGenerator.REDIS_DEL);
    	        keyName
    	            .append(TopFineUtil.getServerName(SERVICE_NAME_SALESERVICE))
    	            .append(TopFineUtil.COLON)
    	            .append(RedisKeyGenerator.METHOD_NAME_MACD)
    	            .append(TopFineUtil.COLON)
    	            .append(str)
    	            .append(TopFineUtil.COLON)
    	            .append(timeType);
    	        
    	        StringBuilder delKeyName = new StringBuilder();
    	        delKeyName.append(RedisKeyGenerator.REDIS_DEL);
    	        delKeyName
    	            .append(TopFineUtil.getServerName(SERVICE_NAME_STORESERVICE))
    	            .append(TopFineUtil.COLON)
    	            .append(RedisKeyGenerator.METHOD_NAME_MARKETRANK2)
    	            .append(TopFineUtil.COLON)
    	            .append(str)
    	            .append(TopFineUtil.COLON)
    	            .append(timeType);
    	        if (!"".equals(RedisKeyGenerator.PARAM_NAME_3)) {
    	      	  delKeyName.append(TopFineUtil.COLON).append(param3.get(i));
    	        }
    	        System.out.println(delKeyName);
    	  	  
    	    }
  }
    
//    for (String timeType : timeAllType) {
//      StringBuilder keyName = new StringBuilder();
//      keyName.append(RedisKeyGenerator.REDIS_DEL);
//      keyName
//          .append(TopFineUtil.getServerName(SERVICE_NAME_SALESERVICE))
//          .append(TopFineUtil.COLON)
//          .append(RedisKeyGenerator.METHOD_NAME_MACD)
//          .append(TopFineUtil.COLON)
//          .append(RedisKeyGenerator.PARAM_NAME_1)
//          .append(TopFineUtil.COLON)
//          .append(timeType);
////      if (!"".equals(RedisKeyGenerator.PARAM_NAME_3)) {
////        keyName.append(TopFineUtil.COLON).append(PARAM_NAME_3);
////      }
//      
//      StringBuilder delKeyName = new StringBuilder();
//      delKeyName.append(RedisKeyGenerator.REDIS_DEL);
//      delKeyName
//          .append(TopFineUtil.getServerName(SERVICE_NAME_STORESERVICE))
//          .append(TopFineUtil.COLON)
//          .append(RedisKeyGenerator.METHOD_NAME_MACD)
//          .append(TopFineUtil.COLON)
//          .append(RedisKeyGenerator.PARAM_NAME_1)
//          .append(TopFineUtil.COLON)
//          .append(timeType);
//      if (!"".equals(RedisKeyGenerator.PARAM_NAME_3)) {
//    	  delKeyName.append(TopFineUtil.COLON).append(PARAM_NAME_3);
//      }
//      System.out.println(keyName);
//      System.out.println(delKeyName);
//      
//    }
  }
}
