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
            // data:{method:query},
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
    });
    $("#cancleChgBtn").click(function () {
        $("#managerDiv").show()
        $("#changeManagerDiv").hide()
    });
    $("#userQuery").click(function () {

        if($("#userId").val()!="") {
            query($("#userId").val(),"query");
        }else{
            alert("请先查询一个用户")
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
                $("#userAccount").text(result.userAccount+"元");
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


    function showBooks(bookMethod) {
        $.ajax({
            dataType:"json",
            type:"post",
            url:"book.do?method="+bookMethod,
            data:{userNum:$("#userId").val()},
            success:function (result) {
                $("#bookImgDl").html("");
                for(var i=0; i<result.length;i++) {
                    var $dt = $("<dt></dt>");
                    // style='background: url('"+result[i].bookImg+"')'
                    $dt.append("<div class='imgDiv' style=\"background: url('/image/"+ result[i].bookImg+"')\">");
                    $dt.append('<input type="hidden" value="'+result[i].bookName+'">');
                    $("#bookImgDl").append($dt);
                }
                $(".imgDiv").click(function () {
                    if($(this).text()=="√") {
                        num--
                        $(this).text("");
                        $("#errorMsg").hide();
                    }else{
                        // alert($(this).find("input").val())//获取书籍名称
                        if(num < 4) {
                            num++;
                            $(this).text("√");
                        }else{
                            $("#errorMsg").show();
                        }
                    }
                });
                $("#clearBtn").click(function () {
                    num=0;
                    $("#errorMsg").hide();
                    $(".imgDiv").text("");
                });
            }
        });
    }
    showBooks()
});
