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
                <span class="userInfo">用户名:</span>
                <span class="userInfo" id="userName"></span><br/>
                <span class="userInfo">用户余额:</span>
                <span class="userInfo" id="userAccount"></span><br/>
                <span class="userInfo">用户状态:</span>
                <span class="userInfo" id="userType"></span><br/>
                    <%--<span class="userInfo">已借书籍:</span>--%>
                <button class="btn btn-success" id="bookChk" style="margin-left: 70%">已借书籍</button>
                <div style="width: 310px;border: solid 0.5px rgba(255,255,255,0.4);"></div>
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
                    <button id="clearBtn" class="btn btn-primary btn-sm" style="margin-left: 5%">清 空</button>
                    <button id="adminTypeBtn" class="btn btn-primary btn-sm" style="margin-left: 5%">管理员状态</button>
                </div>
                <%--修改管理员状态界面--%>
                <div id="changeManagerDiv" style="height: 240px;width: 300px;border: solid 1px white;border-radius: 10px;margin-left: 1%;margin-top: 2%;display: none;">
                    <div style="height: 200px;width: 300px;">
                        <span class="userInfo" style="margin-left: 30%">普通管理员列表</span>
                        <div style="width: 298px;border: solid 0.5px rgba(255,255,255,0.4);"></div>
                        <%--分割线--%>
                    </div>
                    <button id="sureChgBtn" class="btn btn-primary btn-sm" style="margin-left: 19%">确认修改</button>
                    <button id="cancleChgBtn" class="btn btn-primary btn-sm" style="margin-left: 10%">取消修改</button>
                </div>
                <button class="btn btn-danger" id="addUserBtn" style="width: 300px;margin-top: 4%">添加用户</button>
                <div id="addUserDiv" style="margin-top: 2%;margin-left: 1%; width: 300px;height: 100px;border: solid 1px white;border-radius: 10px;display: none;">
                    <input type="text" name="userName" style="width: 260px;border-radius: 5px;margin-top: 3%;margin-left: 3%" placeholder="用户真实姓名">
                    <input type="text" name="userAccount" style="width: 260px;border-radius: 5px;margin-left: 3%" placeholder="用户充值">
                    <input type="button" id="sureBtn" style="margin-left: 55%" class="btn btn-success btn-sm" value="确定"/>
                    <input type="button" id="cancleBtn" class="btn btn-success btn-sm" value="取消"/>
                </div>
            </div>

            <%--右边内容--%>
            <div class="col-md-8 initDiv" style="background: white">
                <div class="titleDiv">书 籍 一 览</div>
                <dl style="margin-top: 3%;margin-left: 2%">
                    <dt>
                        <div class="imgDiv" style="background: url('image/cndqsjzg.jpg') no-repeat">
                            <input type="hidden" value="从你的全世界路过">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/zfzdr.jpg') no-repeat">
                            <input type="hidden" value="追风筝的人">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/jianglaideni.jpg') no-repeat">
                            <input type="hidden" value="将来的你">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/baiduren.jpg') no-repeat">
                            <input type="hidden" value="摆渡人">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/jyzhd.jpg') no-repeat">
                            <input type="hidden" value="解忧杂货店">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/yangpijuan.jpg') no-repeat">
                            <input type="hidden" value="羊皮卷">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/guoyisheng.jpg') no-repeat">
                            <input type="hidden" value="按自己的意愿过一生">
                        </div>
                    </dt>
                    <dt>
                        <div class="imgDiv" style="background: url('image/qingnianwenzhai.jpg') no-repeat">
                            <input type="hidden" value="青年文摘">
                        </div>
                    </dt>
                </dl>
                <div id="errorMsg" style="width: 500px;color: red;display: none;font-size: 1.5em;margin-left: 5%">用户一次最多只能借走4本书!</div>
            </div>
        </div>
    </div>
</body>
</html>
