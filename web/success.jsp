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
                <input type="text" placeholder="请输入用户ID" style="margin-top: 4%"/>
                <button class="btn btn-success btn-sm">查询</button><br/>
                <span class="userInfo">用户ID:</span>
                <span class="userInfo" id="userId"></span><br/>
                <span class="userInfo">用户名:</span>
                <span class="userInfo" id="userName"></span><br/>
                <span class="userInfo">用户余额:</span>
                <span class="userInfo" id="userAccount"></span><br/>
                <span class="userInfo">用户状态:</span>
                <span class="userInfo" id="userType"></span><br/>
                <span class="userInfo">已借书籍:</span>
                <span class="userInfo" id="books"></span><br/>
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
                <div id="errorMsg" style="width: 500px;color: red;display: none;font-size: 1.5em;margin-left: 5%">对不起，您一次最多只能借走4本书!</div>
            </div>
        </div>
    </div>
</body>
</html>
