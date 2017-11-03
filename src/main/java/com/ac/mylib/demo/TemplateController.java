package com.ac.mylib.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模板测试.
 * 使用@RestController(@RestController（等待于 @Controller 和 @RequestBody）)的话，表示传递接收都是json数据，页面会返回/helloHtml字符串
 * 使用@Controller就可以使用模板了
 * 
 * @author Echo
 * 
 */
@Controller
@RequestMapping(value="/view")
public class TemplateController {
    /**
     * 返回html模板.
     */
    @RequestMapping("/hello")
    public String helloHtml(Map<String, Object> map) {
        map.put("hello", "from TemplateController.helloHtml");
        return "/hello";
    }
}
