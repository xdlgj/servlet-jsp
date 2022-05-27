<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  如果要在jsp中写java代码，需要写在脚本段中--%>
<%

    //获取请求域对象
    String name = (String) request.getAttribute("name");
    System.out.println("name:" + name);
    List<String> hobbies = (List<String>) request.getAttribute("hobbies");
    if(hobbies != null){
        for (String hobby : hobbies) {
            System.out.println("hobby:" + hobby);
        }
    }

%>
</body>
</html>
