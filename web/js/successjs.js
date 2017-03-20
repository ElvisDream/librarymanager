/**
 * Created by Elivs on 2017/3/18.
 */
var num=0;
$(function () {
    function adminInfo() {
        $.ajax({
            dataType:"json",
            type:"post",
            url:"admin.do",
            success:function (result) {
                $("#adminName").text(result.adminName)
                $("#adminPower").text(result.adminPower)
                if(result.adminPower != "super") {
                    $("#adminTypeBtn").hide();
                }
            }
        });
    }
    adminInfo();

    $("#addUserBtn").click(function () {
        $("#addUserDiv").show();
    });
    $("#cancleBtn").click(function () {
        $("#addUserDiv").hide();
    });

    $("#adminTypeBtn").click(function () {
        $("#managerDiv").hide()
        $("#changeManagerDiv").show()
        getUser("getAll");
    });
    $("#cancleChgBtn").click(function () {
        $("#managerDiv").show()
        $("#changeManagerDiv").hide()
    });
    $("#userQuery").click(function () {

        if($("#userId").val()!="") {
            query($("#userId").val(),"query");
        }else{
            alert("请先输入一个用户ID")
        }
    });
    $("#delUser").click(function () {
        if($("#userId").val()!="") {
            query($("#userId").val(),"del")
        }else{
            alert("请先查询一个用户")
        }
    });
    $("#sureBtn").click(function () {
        if($("#userRealName").val()!="" || $("#userMoney").val() != "") {
            query("","add")
        }else{
            alert("请先完善用户信息")
        }
    });
    $("#bookChk").click(function () {
        if($("#userId").val()!="") {
            showBooks("userBook");
        }else{
            alert("请先查询一个用户!")
        }
    });

    $("#rebackBookList").click(function () {
        showBooks("");
    });

    //查询用户信息
    function query(userId,method) {
        $.ajax({
            dataType:"json",
            url:"user.do?method="+method,
            type:'post',
            data:{userId:userId,userName:$("#userRealName").val(),userAccount:$("#userMoney").val()},
            success:function (result) {
                //此处开始写获取用户信息
                $("#getUserId").text(result.userNum);
                $("#userName").text(result.userName);
                $("#userAccount").text(result.userAccount);
                var userType = result.userType;
                if(userType == 1) {
                    $("#userType").text("正常")
                }else {
                    $("#userType").text("已被注销")
                }
            }
        })
    }
    $("#addAdminBtn").click(function () {
        $("#changeManagerDiv").hide();
        $("#addAdminDiv").show();
    });
    $("#rebackBtn").click(function () {
        $("#addAdminDiv").hide();
        $("#changeManagerDiv").show();
    });

    //查询所有书籍列表
    function showBooks(bookMethod,bookIndex) {
        $.ajax({
            dataType:"json",
            type:"post",
            url:"book.do?method="+bookMethod,
            data:{userNum:$("#userId").val(),bookId:bookIndex},
            success:function (result) {
                $("#bookImgDl").html("");
                for(var i=0; i<result.length;i++) {
                    var $dt = $("<dt></dt>");
                    $dt.append("<div class='imgDiv' style=\"background: url('/image/"+ result[i].bookImg+"')\">");
                    $dt.append('<input type="hidden" value="'+result[i].bookName+'">');
                    $dt.append("<input type='hidden' id='bookId' value='"+result[i].bookId+"'/>")
                    $("#bookImgDl").append($dt);
                }
                $(".imgDiv").click(function () {
                    if($(this).text()=="√") {
                        num--
                        $(this).text("");
                        str0 = "&"+$(this).next().next().val();
                        bookIndex = bookIndex.slice(0, bookIndex.length - str0.length);
                        $("#errorMsg").hide();
                    }else{
                        if(num < 4) {
                            num++;
                            $(this).text("√");
                            //此处获取到用户借的书的所有ID的字符串拼接
                            bookIndex += "&"+$(this).next().next().val();
                            // alert(bookIndex);
                        }else{
                            $("#errorMsg").text("用户一次最多只能借走4本书!");
                            $("#errorMsg").show();
                        }
                    }
                });
                $("#clearBtn").click(function () {
                    num=0;
                    bookIndex = "";
                    $("#errorMsg").hide();
                    $(".imgDiv").text("");
                });
                $("#rentBtn").click(function () {

                    rentBook(bookIndex);
                    bookIndex = "";
                    $(".imgDiv").text("");
                    query($("#userId").val(),"query");
                });
            }
        });
    }
    showBooks();

    function rentBook(bookIndex) {

        if($("#userId").val() !="") {

            if(bookIndex != undefined) {
                if($("#userType").text()=="正常") {
                    var size = bookIndex.split("&").length-1;
                    if($("#userAccount").text()<size*2) {
                        alert("余额不足，请先充值!")
                    }else{
                        showBooks("rent",bookIndex);
                        $("#errorMsg").text("借阅成功！");
                        $("#errorMsg").fadeIn();
                        $("#errorMsg").fadeOut(1000);
                    }
                }else{
                    alert("该用户已被注销！")
                }
            }else{
                $("#errorMsg").text("至少先选择一本书！");
                $("#errorMsg").fadeIn();
                $("#errorMsg").fadeOut(1000);
            }
        }else{
            alert("请先输入用户ID!")
        }
    }

    //删除管理员，并返回其管理员列表
    function getUser(method,adminId) {
        $.ajax({
            dataType:"json",
            type:"post",
            url:"admin.do?method="+method,
            data:{adminId:adminId},
            success:function (result) {
                $("#adminDl").html("");
                for(var i=0;i<result.length;i++) {
                    $dd=$("<dd style='margin-top: 3%;'></dd>");
                    $dd.append("<button class='btn btn-danger btn-sm removeAdmin' style='margin-right: 10%'>删除</button>")
                    $dd.append('<input type="hidden" value="'+result[i].adminId+'">');
                    $dd.append("<span >"+result[i].adminName+"</span>");
                    $("#adminDl").append($dd);
                }
                $(".removeAdmin").click(function () {
                    adminId = $(this).next().val();
                    delAdmin(adminId);
                });
            }
        });
    };
    function delAdmin(adminId) {
        getUser("remove", adminId);
    }
});