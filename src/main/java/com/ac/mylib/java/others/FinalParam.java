package com.ac.mylib.java.others;

public class FinalParam {
	  public static void main(String args)
      {
            LoginInfo login = new LoginInfo();
            login.setPassword("1235");
            login.setUserName("mygod");
            System.out.println("username:"+login.getUserName()+",password:"+login.getPassword());
            checkLoginInfo(login);
            System.out.println("username:"+login.getUserName()+",password:"+login.getPassword());
      }
     
      public static void checkLoginInfo(final LoginInfo login)
      {
		// login = new LoginInfo();//error,编译不过去
		login.setUserName("yun");
      }

}
