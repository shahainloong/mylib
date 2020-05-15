package com.ac.mylib.controller;

import com.ac.mylib.entity.User;
import com.ac.mylib.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-05-10 00:02:17
 */
@RestController
@RequestMapping("user")
public class UserController {
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
    @GetMapping("selectOne")
    public User selectOne(@RequestParam(name = "id") final Integer id) {
        return this.userService.queryById(id);
    }

}