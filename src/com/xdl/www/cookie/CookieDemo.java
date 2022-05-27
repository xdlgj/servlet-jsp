package com.xdl.www.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * 注意
 *      1、cookie只在当前浏览器中有效（不夸浏览器）
 *      2、cookie 不能存中文
 *         如果一定要存中文，需要通过URLEncoder.encode()方法进行编码，获取时通过URLDecoder.decode()方法进行解码
 *         该方法已经被弃用不建议使用
 *      3、如果出现同名的cookie对象，则会覆盖
 *      4、Cookie的存储数量是有上限的，不同浏览器的上限不同，cookie存储的大小也是有限的大约在4kb
 *      5、只有访问的路径中包含cookie对象的path值，才可以获取到cookie对象
 */
@WebServlet("/cookie")
public class CookieDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、创建Cookie对应
        Cookie cookie = new Cookie("name", "xdl");
        //2、发送Cookie对象
        resp.addCookie(cookie);


        /************************设置cookie过期时间*****************************/
        /*到期时间：负整数 （默认值为-1，表示只在浏览器内存中存活，关闭浏览器失效）*/
        Cookie ck2 = new Cookie("name2", "xdl2");
        ck2.setMaxAge(-3);
        resp.addCookie(ck2);
        /*到期时间: 正整数(表示存活指定的描述，会将数据存在磁盘中)*/
        Cookie ck3 = new Cookie("name3", "xdl3");

        ck3.setMaxAge(30);
        resp.addCookie(ck3);
        /*到期时间：0（表示删除cookie）*/
        Cookie ck4 = new Cookie("name4", "xdl4");
        ck4.setMaxAge(0);
        resp.addCookie(ck4);

        /*******************获取cookie***********************/
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                // 获取cookie的key和value
                System.out.println(ck.getName() + ":" + ck.getValue());
            }

        }
    }
}
