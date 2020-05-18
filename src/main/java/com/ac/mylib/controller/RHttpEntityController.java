package com.ac.mylib.controller;

import com.ac.mylib.entity.User;
import com.ac.mylib.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 以后Controller这样命名，R开头的代表Restful的控制器
 *
 * @author Echo
 * @since 2020-05-10 00:02:17
 */
@RestController
@RequestMapping(path = "/client")
public class RHttpEntityController {
    private static final Logger logger = LoggerFactory.getLogger(RHttpEntityController.class);
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
    public ResponseEntity<?> read(@RequestParam(name = "id") String id) {
//        if (id.isEmpty()) {
//            return ResponseEntity;
//        }
        String url = "https://rapid.sap.com/authoring/api/v1/buildSi2sc/read/005056821C321ED89EDC1DCFDF8660FE";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "text/html;charset=utf-8");
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(
                url, HttpMethod.GET, requestEntity,
                String.class);
        return response;
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersById(@PathVariable(value = "id", required = true) Integer id, @RequestParam(value = "age") Integer age) {

        logger.info("id is: " + id + " and age is: " + age);
        return this.userService.getUsersById(id, age);
    }

}