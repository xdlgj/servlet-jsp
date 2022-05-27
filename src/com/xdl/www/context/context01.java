package com.xdl.www.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 获取ServletContext对象
 */
@WebServlet("/context01")
public class context01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 通过request对象获取
        ServletContext servletContext1 = req.getServletContext();
        // 通过session对象获取
        ServletContext servletContext2 = req.getSession().getServletContext();
        // 通过servletConfig对象获取
        ServletContext servletContext3 = getServletConfig().getServletContext();
        // 直接获取
        ServletContext servletContext4 = getServletContext();

        /*常用方法*/
        // 获取当前服务器版本信息
        String serverInfo = servletContext1.getServerInfo();
        System.out.println(serverInfo);
        // 获取项目的真实路径
        String realPath = servletContext1.getRealPath("/");
        System.out.println(realPath);
    }
}
