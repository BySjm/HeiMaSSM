<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>有人正在偷偷💜着你</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
<h3>首页</h3>
<hr>
<img style="width: 100px;height: 100px;" src="${pageContext.request.contextPath}/img/longma.jpg">
<hr>
<button id="ajaxBtn">ajax异步交互</button>
<script>
    $('#ajaxBtn').click(function () {
        let url = '${pageContext.request.contextPath}/ajaxRequest';
        let data = '[{"id":"1","username":"jack"},{"id":"2","username":"tom"}]'
        $.ajax({
            url:url,
            type:"post",
            data:data,
            contentType:"application/json;charset=utf-8",
            success:function (resp) {
                alert(resp);
            }
        })
    })
</script>
<hr>
<form method="post" action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data">
    姓名：<input type="text" name="username"> <br>
    头像：
    <input type="file" name="picFile"> <br>
    <input type="file" name="picFile"> <br>
    <input type="file" name="picFile"> <br>
    <input type="submit" value="文件上传"> <br>
</form>
</body>
</html>
