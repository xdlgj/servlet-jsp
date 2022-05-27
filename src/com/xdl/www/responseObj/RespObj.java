package com.xdl.www.responseObj;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应数据
 * 1、getWriter()            字符输出流，只能输出字符串
 * 2、getOutputStream()      字节输出流，可输入一切数据
 *
 * 两种方式不能同时使用，如果同时使用会报错：java.lang.IllegalStateException: 已为此响应调用getWriter（）
 *
 * 乱码解决：
 *  方法1：
 *    resp.setCharacterEncoding("utf8"); // 服务器编码
 *    resp.setHeader("content-type", "text/html;charset=utf8"); // 客户端编码
 *    设置客户端和服务端的编码方式支持中文，并且保持一致
 *  方法2：
 *    resp.setContentType("text/html;charset=UTF-8"); 两步合成一步
 */
@WebServlet("/resp")
public class RespObj extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码问题
        //resp.setCharacterEncoding("utf8"); // 服务器编码
        //resp.setHeader("content-type", "text/html;charset=utf8"); // 客户端编码
        resp.setContentType("text/html;charset=UTF-8");
        // 1、获取字符流对象
        //PrintWriter writer = resp.getWriter();
        // 2、输出数据
        //writer.write("你好!");
        /*************************字节输出******************************/
        ServletOutputStream stream = resp.getOutputStream();
        stream.write("你好".getBytes());
    }
}
