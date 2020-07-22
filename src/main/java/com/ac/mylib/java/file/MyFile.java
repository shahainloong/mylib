package com.ac.mylib.java.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MyFile {
    private static final Logger logger = LoggerFactory.getLogger(MyFile.class);
    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\D\\workspace-idea\\mylib\\src\\main\\java\\com\\ac\\mylib\\java\\mail\\mail.properties");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//        System.out.println(file.getParent());
//        System.out.println(file.toString());
//        Path path = Paths.get("mail", "mail.properties");
//        System.out.println(path.toString());
//        Properties properties = new Properties();
//        InputStream in = MyFile.class.getClassLoader().getResourceAsStream("mail.properties");
//        properties.load(in);
//        logger.info(properties.toString());
//        System.out.println(properties.getProperty("mail.smtps.user"));
        File f = new File(MyFile.class.getResource("/").getPath());
        File f1 = new File(MyFile.class.getResource("/ehcache.xml").getPath());
        File f2 = new File(MyFile.class.getResource("").getPath());
        URL resource = MyFile.class.getClassLoader().getResource("ehcache.xml");
        System.out.println(f);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(resource);
    }
}
