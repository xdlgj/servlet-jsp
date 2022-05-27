package com.xdl.www;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期
 * 1、实例和初始化时机： init
 * 2、就绪/调用/服务阶段：service
 * 3、销毁时机： destroy
 */
@WebServlet("/cycle")
public class LifeCycle extends HttpServlet {
    /**
     * 初始化方法，
     * 系统方法，服务器自动调用
     * 当请求第一次到达servlet容器时，servlet容器会判断该servlet对象是否存在，如果不存在则创建实例并初始化
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("servlet 被创建了");
    }

    /**
     * 每次请求过来都会调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理请求....");
    }

    /**
     * 系统方法，在关闭服务时调用
     */
    @Override
    public void destroy() {
        System.out.println("servlet 被销毁了");
    }
}
