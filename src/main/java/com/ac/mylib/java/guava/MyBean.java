package com.ac.mylib.java.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

public class MyBean {
    private String id;
    private String name;
    private String phone;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id","C5294803").toString();
    }

    public static void main(String[] args) {
        System.out.println(new MyBean().toString());
        List<String> names = Lists.newArrayListWithCapacity(16);
        names.add("Ada");
        names.add("Bob");
        System.out.println(Lists.newArrayList("Cat"));

    }
}
