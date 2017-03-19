<%--
  Created by IntelliJ IDEA.
  User: Elivs
  Date: 2017/3/17
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
    <script type="text/javascript" src="js/jquery-1.11.2-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function virify() {
            var adminName = $("#adminName").val();
            var adminPwd = $("#adminPwd").val();
            if(adminName == "" || adminPwd == "") {
                $("#errorMsg").text("用户名或密码不能为空！");
                $("#errorMsg").fadeIn(1000);
                $("#errorMsg").fadeOut(1000);
                return false;
            }else{
                return true;
            }
        }

        $(function () {
            $("#adminName").focus(function () {
                $("#errorMsg").fadeOut(1000);
            });
            $("#adminPwd").focus(function () {
                $("#errorMsg").fadeOut(1000);
            });
        });
    </script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mycss.css">
</head>
<body style="background: url('image/bj.jpg') round no-repeat">

    <div class="container-fluid" style="background: rgba(0,0,0,0.55);height: 638px">
        <div class="row" style="margin-top: 1%">
            <div class="col-md-12">
                <div id="loginDiv">
                    <form action="admin.do" method="post" onsubmit="return virify()">
                        <b><span style="margin-left: 5%;font-size: 2em;color: #2a8cba;">欢 迎 登 陆</span></b>
                        <input type="hidden" name="method" value="login"/>
                        <input type="text" id="adminName" name="adminName" style="margin-left: 40%;border-radius:2px" placeholder="账户"/>
                        <input type="password" id="adminPwd" style="border-radius: 2px" name="adminPwd" placeholder="密码"/>
                        <input type="submit" class="btn btn-success btn-sm" value="登陆"/>
                        <span style="color:red;font-size: 1.2em;margin-left: 1%;" id="errorMsg">${errorMsg}</span>
                    </form>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 6%;width: 1330px;margin-left: 2px">
            <div class="col-md-12" style="height: 300px;background: rgba(255, 255, 255, 0.73);padding-top: 6%;border-radius: 10px">
                <span style="font-size: 5em;margin-left: 32%;">图 书 管 理 系 统</span>
            </div>
        </div>
    </div>
</body>
</html>
