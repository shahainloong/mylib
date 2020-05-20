package com.ac.mylib.controller;

import com.ac.mylib.entity.User;
import com.ac.mylib.java.mail.MailTest;
import com.ac.mylib.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.Response;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 以后Controller这样命名，R开头的代表Restful的控制器
 *
 * @author Echo
 * @since 2020-05-10 00:02:17
 */
@RestController
@RequestMapping(path = "/path")
public class RPathController {
    private static final Logger logger = LoggerFactory.getLogger(RPathController.class);
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(path = "/read", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> read() {
        String propFileName = "mail.properties";
        Properties props = new Properties();
        try { // 捕捉异常
            // 将Properties文件读取到InputStream对象中
            InputStream in = getClass().getResourceAsStream(propFileName);
            props.load(in); // 通过输入流对象加载Properties文件
        } catch (Exception e) {
            e.printStackTrace(); // 输出异常信息
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersById(@PathVariable(value = "id", required = true) Integer id, @RequestParam(value = "age") Integer age) {

        logger.info("id is: " + id + " and age is: " + age);
        return this.userService.getUsersById(id, age);
    }

}