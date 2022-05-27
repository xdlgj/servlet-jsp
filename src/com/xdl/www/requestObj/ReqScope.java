package com.xdl.www.requestObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求转发和HttpServletRequest作用域
 */

@WebServlet("/reqScope")
public class ReqScope extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "xdl");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("读书");
        hobbies.add("学习");
        req.setAttribute("hobbies", hobbies);
        // 转发到index.jsp页面
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
