package com.xdl.www.uploadfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * 文件上传
 * 使用注解@MultipartConfig将一个servlet 标识为支持文件上传
 * servlet将multipart/form-data 的post请求封装成Part对象，通过Part对上传的文件进行操作
 */
@WebServlet("/upload")
@MultipartConfig // 如果是文件上传，必须设置该注解
public class UploadFile extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        // 获取Part对象
        Part part = req.getPart("file");
        // 获取文件名
        String fileName = part.getSubmittedFileName();
        // 获取服务器地址
        String filePath = req.getServletContext().getRealPath("/");
        // 保存文件
        part.write(filePath + "/" + fileName);
    }
}
