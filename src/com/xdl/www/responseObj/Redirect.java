package com.xdl.www.responseObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 *  服务器端指导，客户端行为
 *  存在两次请求
 *  地址栏会发生变化
 *  request对象不共享
 */
@WebServlet("/redirect")
public class Redirect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  参数可以是相对路径resp或绝对路径/web/resp
        resp.sendRedirect("resp");
    }
}
