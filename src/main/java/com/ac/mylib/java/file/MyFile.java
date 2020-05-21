package com.ac.mylib.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MyFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\D\\workspace-idea\\mylib\\src\\main\\java\\com\\ac\\mylib\\java\\mail\\mail.properties");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.toString());
        Path path = Paths.get("mail", "mail.properties");
        System.out.println(path.toString());
        Properties properties = new Properties();
        InputStream in = MyFile.class.getClassLoader().getResourceAsStream("mail.properties");
        properties.load(in);
        System.out.println(properties.getProperty("mail.smtps.user"));
    }
}
