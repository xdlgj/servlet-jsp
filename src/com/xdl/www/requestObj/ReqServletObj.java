package com.xdl.www.requestObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequest 对象
 */
@WebServlet("/req")
public class ReqServletObj extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /***************************6个常用方法*********************************************/
        //http://127.0.0.1:8080/web/req?name=xdl&age=20
        // 返回的是StringBuffer类型 需要转换为String类型
        String url = req.getRequestURL() + "";
        System.out.println("url:" + url); // http://127.0.0.1:8080/web/req

        String uri = req.getRequestURI();
        System.out.println("uri:" + uri); // /web/req

        String queryString = req.getQueryString();
        System.out.println("queryString:" + queryString); // name=xdl&age=20

        String protocol = req.getProtocol();
        System.out.println("protocol:" + protocol); // HTTP/1.1, 协议

        String method = req.getMethod();
        System.out.println("method:" + method); // GET

        String contextPath = req.getContextPath();
        System.out.println("contextPath:" + contextPath); // /web， webapp名称/站点名
        System.out.println("/******************************获取请求参数*******************************************/");
        // 所有方法获取参数都适用
        /**
         * 中文乱码问题 Tomcat8及以上get方法不存在乱码，post方法会存在乱码问题
         */
        req.setCharacterEncoding("utf8");
        String name = req.getParameter("name");
        System.out.println("name:" + name);

        String password = req.getParameter("password");
        System.out.println("password:" + password);

        // 获取指定名称的参数的所有值，返回字符串数组（用于复选框）
        String[] hobbys = req.getParameterValues("hobby");
        // 判断数组是否为空
        if (hobbys != null) {
            for (String bobby: hobbys){
                System.out.println("hobby:" + bobby);
            }
        }
    }
}
