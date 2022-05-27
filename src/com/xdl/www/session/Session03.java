package com.xdl.www.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session对象的销毁
 *  1、默认到期时间
 *      Tomcat中session默认存活时间为30min，即不操作界面的时间，一旦有操作，session会重新计时
 *      可以在tomcat中的conf目录下的web.xml文件中进行修改
 *     <session-config>
 *         <session-timeout>30</session-timeout>
 *     </session-config>
 *  2、手动设置到期时间
 *  session.getMaxInactiveInterval();
 *         session.setMaxInactiveInterval(15);
 *  3、立即销毁
 *      session.invalidate();
 *  4、关闭浏览器失效
 *      session底层依赖cookie，cookie对象默认只在浏览器中存活，关闭浏览器即失效
 *  5、关闭服务器失效
 */
@WebServlet("/session03")
public class Session03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取session域对象
        HttpSession session = req.getSession();
        session.setAttribute("name", "xdl");


        System.out.println(session.getMaxInactiveInterval());
        // 设置15s之后失效
        session.setMaxInactiveInterval(15);
        session.invalidate();
    }
}
