package com.ac.mylib.java.guava;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class MyChar {
    public static void main(String[] args) throws IOException {
        CharSource charSource = Files.asCharSource(new File("D:\\workspace-idea\\mylib\\src\\main\\java\\com\\ac\\mylib\\java\\guava\\guava.txt"), Charsets.UTF_8);
        System.out.println(charSource.readLines());
        ByteSource byteSource = Files.asByteSource(new File("D:\\workspace-idea\\mylib\\src\\main\\java\\com\\ac\\mylib\\java\\guava\\guava.txt"));

        System.out.println(byteSource.read().length);
        BaseEncoding baseEncoding = BaseEncoding.base64();
        System.out.println(baseEncoding.encode("hello".getBytes()));
        System.out.println("a".getBytes().length);

    }
}
