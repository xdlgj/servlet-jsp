<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>session域对象</h2>
<%--  如果要在jsp中写java代码，需要写在脚本段中--%>
<%

    //获取请求域对象
    String name = (String) request.getAttribute("uname");
    // 把信息输出到界面上
    out.println("name:" + name + "<br>");

    //获取session域对象
    HttpSession sess = request.getSession();
    out.println(sess.getAttribute("name") + "<br>");
    out.println(sess.getAttribute("password") + "<br>");
%>
</body>
</html>
