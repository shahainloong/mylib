package com.ac.mylib.controller;

import com.ac.mylib.entity.User;
import com.ac.mylib.service.UserService;
import com.ac.mylib.util.CommonsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-05-10 00:02:17
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
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
    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersById(@PathVariable(value = "id", required = true) Integer id, @RequestParam(value = "age") Integer age) {

        logger.info("id is: " + id + " and age is: " + age);
        return this.userService.getUsersById(id, age);
    }

}