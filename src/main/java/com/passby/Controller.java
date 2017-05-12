package com.passby;

import com.passby.entity.User;
import com.passby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 第一个
 *
 * @author zhangmq
 * @Create 2017-05-09 16:54
 */
@WebServlet("/myController")
public class Controller extends HttpServlet {
    @Autowired
    UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        User user = userService.getById(1);
        req.setAttribute("name",user.getUserName());
        System.out.println(user.getUserName());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService uService = (UserService) application.getBean("userService");
        User user = uService.getById(1);
        System.out.println(user.getUserName());
        User user1 = new User();
        user1.setUserName("wangsdfwu");
        user1.setPassword("123456");
        user1.setAge(25);
        int num = uService.save(user1);
        System.out.println("成功了吗=="+num);
    }
}
