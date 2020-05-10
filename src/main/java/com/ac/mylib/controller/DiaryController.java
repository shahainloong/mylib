package com.ac.mylib.controller;

import com.ac.mylib.domain.Diary;
import com.ac.mylib.util.MyPagination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/diaries")
public class DiaryController {

    MyPagination pagination = null;// 数据分页类的对象
//    DiaryDao dao = null;// 日记相关的数据库操作类的对象


    @RequestMapping(value = "", method = RequestMethod.GET)
    public void listAllDiary(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam String page) throws ServletException, IOException {

        String strPage = page;// 获取当前页码

        int Page = 1;
        List<Diary> list = null;
//        if (strPage == null) {// 当页面初次运行
//            String sql = "select d.*,u.username from tb_diary d inner join tb_user u on u.id=d.userid order by d.writeTime DESC limit 50";
//            pagination = new MyPagination();
//            list = dao.queryDiary(sql); // 获取日记内容
//            int pagesize = 4; // 指定每页显示的记录数
//            list = pagination.getInitPage(list, Page, pagesize); // 初始化分页信息
//            request.getSession().setAttribute("pagination", pagination);
//        } else {
//            pagination = (MyPagination) request.getSession().getAttribute(
//                    "pagination");
//            Page = pagination.getPage(strPage);// 获取当前页码
//            list = pagination.getAppointPage(Page); // 获取指定页数据
//        }
        request.setAttribute("diaryList", list); // 保存当前页的日记信息
        request.setAttribute("Page", Page); // 保存的当前页码
        request.setAttribute("url", "listAllDiary");// 保存当前页面的URL
        request.getRequestDispatcher("listAllDiary.jsp").forward(request,
                response);// 重定向页面

    }

}
