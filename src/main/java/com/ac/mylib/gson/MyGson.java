package com.ac.mylib.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Objects;

public class MyGson {

    public static void main(String[] args)
    {
        Gson gson = new GsonBuilder().create();
        Account account = new Account("00001", "Freeman", "13000000000");
        System.out.println(gson.toJson(account));

        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList.add(account);
        accountList.add(account);
        System.out.println(gson.toJson(accountList));

        String json = "{\"uid\":\"00001\",\"userName\":\"Freeman\",\"telNumber\":\"13000000000\"}";
        Account receiveAccount = gson.fromJson(json, Account.class);
        System.out.println(receiveAccount.toString());

        Objects.nonNull("hello");
        Objects.equals("","");


    }
}
