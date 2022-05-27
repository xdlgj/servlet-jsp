package com.xdl.www.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session域对象
 *
 */
@WebServlet("/session02")
public class Session02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取session域对象
        HttpSession session = req.getSession();
        session.setAttribute("name", "xdl");
        session.setAttribute("password", "123456");
        session.removeAttribute("password"); // key不存在不会报错

        // 设置request域对象
        req.setAttribute("uname", "gj");

        // 请求转发
        req.getRequestDispatcher("session.jsp").forward(req, resp);
    }
}
