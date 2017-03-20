<%--
  Created by IntelliJ IDEA.
  User: Elivs
  Date: 2017/3/18
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.2-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <link rel="stylesheet" href="css/successcss.css">
    <script type="text/javascript" src="js/successjs.js"></script>
</head>
<body style="background: url('image/backimg.jpg') round no-repeat;">
    <div class="container-fluid" style="background: rgba(0,0,0,0.53);height: 638px">
        <div class="row">
            <%--左边内容--%>
            <div class="col-md-3 initDiv">
                <input type="text" id="userId" placeholder="请输入用户ID" style="margin-top: 4%"/>
                <button id="userQuery" class="btn btn-success btn-sm">查询</button>
                <button id="delUser" class="btn btn-success btn-sm" style="margin-left: 2%">注销</button><br/>
                <span class="userInfo">用户ID:</span>
                <span class="userInfo" id="getUserId"></span><br/>
                <span class="userInfo">用户姓名:</span>
                <span class="userInfo" id="userName"></span><br/>
                <span class="userInfo">用户余额:</span>
                <span class="userInfo" id="userAccount"></span><br/>
                <span class="userInfo">用户状态:</span>
                <span class="userInfo" id="userType"></span><br/>
                <button class="btn btn-success btn-sm" id="bookChk" style="margin-left: 30%">已借书籍</button>
                <button id="rebackBookList" class="btn btn-danger btn-sm" style="margin-left: 5%">返回书籍列表</button>
                <div style="width: 310px;border: solid 0.5px rgba(255,255,255,0.4);margin-top: 5%"></div>
                <%--分割线--%>
                <%--管理员界面--%>
                <div id="managerDiv" style="height: 240px;width: 300px;border: solid 1px white;border-radius: 10px;margin-left: 1%;margin-top: 2%;display: block;">
                    <div style="margin-top: 5%;margin-left: 2%;width: 280px;height: 180px;">
                        <div style="margin-top: 7%;margin-left: 2%">
                            <span class="userInfo">管理员姓名:</span>
                            <span class="userInfo" id="adminName"></span><br/>
                        </div>
                        <div style="margin-top: 5%;margin-left: 2%">
                            <span class="userInfo">管理员权限:</span>
                            <span class="userInfo" id="adminPower"></span><br/>
                        </div>
                    </div>
                    <button id="rentBtn" class="btn btn-primary btn-sm" style="margin-left: 10%">借 阅</button>
                    <button id="clearBtn" class="btn btn-danger btn-sm" style="margin-left: 5%">清 空</button>
                    <button id="adminTypeBtn" class="btn btn-primary btn-sm" style="margin-left: 5%">管理员状态</button>
                </div>
                <%--修改管理员状态界面--%>
                <div id="changeManagerDiv" style="height: 240px;width: 300px;border: solid 1px white;border-radius: 10px;margin-left: 1%;margin-top: 2%;display: none;">
                    <div style="height: 200px;width: 300px;">
                        <span class="userInfo" style="margin-left: 30%">普通管理员列表</span>
                        <div style="width: 298px;border: solid 0.5px rgba(255,255,255,0.4);"></div>
                        <%--分割线--%>
                        <div style="width: 250px; height: 150px;margin-left: 5%">
                            <dl id="adminDl" style="color: white;font-size: 1.2em"></dl>
                        </div>
                    </div>
                    <button id="addAdminBtn" class="btn btn-primary btn-sm" style="margin-left: 15%">增加管理员</button>
                    <button id="cancleChgBtn" class="btn btn-danger btn-sm" style="margin-left: 5%">返回上级</button>

                </div>

                <div id="addAdminDiv" style="height: 240px;width: 300px;border: solid 1px white;border-radius: 10px;margin-left: 1%;margin-top: 2%;display: none;">
                    <span class="userInfo" style="margin-left: 30%">添加管理员</span>
                    <div style="width: 298px;border: solid 0.5px rgba(255,255,255,0.4);"></div>
                    <form action="admin.do" method="post">
                        <div style="height: 170px;width: 300px;">
                            <input type="text" name="adminName" style="margin-left: 15%;margin-top: 17%" placeholder="登陆账号"/>
                            <input type="password" name="adminPwd" style="margin-left: 15%;margin-top: 5%" placeholder="密码"/>
                            <input type="hidden" name="method" value="add">
                        </div>
                        <input type="submit" class="btn btn-primary btn-sm" style="margin-left: 15%" value="添加">
                        <input type="button" class="btn btn-danger btn-sm" style="margin-left: 10%" id="rebackBtn" value="返回上级">
                    </form>
                </div>

                <button class="btn btn-danger" id="addUserBtn" style="width: 300px;margin-top: 4%">添加用户</button>
                <div id="addUserDiv" style="margin-top: 2%;margin-left: 1%; width: 300px;height: 100px;border: solid 1px white;border-radius: 10px;display: none;">
                    <input type="text" id="userRealName" style="width: 260px;border-radius: 5px;margin-top: 3%;margin-left: 3%" placeholder="用户真实姓名">
                    <input type="text" id="userMoney" style="width: 260px;border-radius: 5px;margin-left: 3%" placeholder="用户充值">
                    <input type="button" id="sureBtn" style="margin-left: 55%" class="btn btn-success btn-sm" value="确定"/>
                    <input type="button" id="cancleBtn" class="btn btn-success btn-sm" value="取消"/>
                </div>
            </div>

            <%--右边内容--%>
            <div class="col-md-8 initDiv" style="background: white">
                <div class="titleDiv">书 籍 一 览</div>
                <dl style="margin-top: 3%;margin-left: 2%" id="bookImgDl"></dl>
                <div id="errorMsg" style="width: 500px;color: red;display: none;font-size: 1.5em;margin-left: 5%;clear: both;">用户一次最多只能借走4本书!</div>
            </div>
        </div>
    </div>
</body>
</html>
