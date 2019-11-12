<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h3>springMVC知识学习</h3>
<a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=jack">基本类型</a>
<hr>
<form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
    编号：<input type="text" name="id">
    姓名：<input type="text" name="username">
    <br><input type="submit" value="对象类型">
</form>
<hr>
<form action="${pageContext.request.contextPath}/user/arrayParam">
    批量删除：
    <br>
    <input type="checkbox" name="ids" value="1"><br>
    <input type="checkbox" name="ids" value="2"><br>
    <input type="checkbox" name="ids" value="3"><br>
    <input type="checkbox" name="ids" value="4"><br>
    <input type="checkbox" name="ids" value="5"><br>
    <input type="submit" value="数组类型">
</form>
<hr>
<form action="${pageContext.request.contextPath}/user/queryVoParam">
    关键字:<input type="text" name="keyword"><br>
    对象类型:
    <input type="text" name="user.id"><br>
    <input type="text" name="user.username"><br>
    list类型:
    <input type="text" name="list[0].id"><br>
    <input type="text" name="list[0].username"><br>
    <input type="text" name="list[1].id"><br>
    <input type="text" name="list[1].username"><br>
    map类型:
    <input type="text" name="map['k1'].id"><br>
    <input type="text" name="map['k1'].username"><br>
    <input type="text" name="map['k2'].id"><br>
    <input type="text" name="map['k2'].username"><br>
    <br>
    <input type="submit" value="复杂类型">
</form>
<hr>
<form action="${pageContext.request.contextPath}/user/converterParam">
    生日：<input type="text" name="birthday"> （格式：1990-01-01）
    <br> <input type="submit" value="自定义类型转换">
</form>

<hr>
<a href="${pageContext.request.contextPath}/user/findByPage?pageNo=5">分页查询</a>
<hr>
<a href="${pageContext.request.contextPath}/user/requestHeader">接收请求头信息</a>
<hr>
<a href="${pageContext.request.contextPath}/user/cookieValue">接收cookie的值</a>
<hr>
<a href="${pageContext.request.contextPath}/user/servletAPI">获取servlet原生API</a>
</body>
</html>