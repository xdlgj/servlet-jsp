* 创建一个servlet项目的目录结构如下：
```
web
├── src  // 用于存放源代码
├── web  // 用于存放html、jsp文件, 不管项目名称是什么这个目录都是web
│   ├── WEB-INF
│   │   └── web.xml
│   └── index.jsp
└── web.iml
其中在idea中还有External Libraries 目录里面包含
一个jdk自带的包
Tomcat安装目录lib中的jsp-api.jar 和 servlet-api.jar包
```