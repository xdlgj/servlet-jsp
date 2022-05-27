package com.xdl.www;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现简单的servlet
 * 1、创建一个普通公共的java类
 * 2、实现Servlet的规范，继承HttpServlet类
 * 3、重写service方法，用来处理请求
 * 4、设置注解，指定访问的路径
 */

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {
    // Ctrl + o 实现重写快捷健
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet");
        // 通过流输出数据到浏览器中
        resp.getWriter().write("Hello Servlet");
    }
}

