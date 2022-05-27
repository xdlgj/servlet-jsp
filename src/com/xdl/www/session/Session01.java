package com.xdl.www.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session的获取和常用方法
 *      req.getSession()： 获取对象时前先判断是否存在，存在则获取session对象，不存在则创建
 *
 * 说明：
 * 第一次访问时服务器会设置cookie：JSESSIONID=6FCD625846FD5D2F16B026039FCA99B9
 */
@WebServlet("/session01")
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        HttpSession session =  req.getSession();
        // 获取session的会话标识符
        String id = session.getId();
        System.out.println(id);
        // 获取session的创建时间
        long createTime = session.getCreationTime();
        System.out.println(createTime);
        // 获取最后一次访问时间
        long lastTime = session.getLastAccessedTime();
        System.out.println(lastTime);
        // 判断是否是新的session对象
        Boolean isNew = session.isNew();
        System.out.println(isNew);
    }
}
