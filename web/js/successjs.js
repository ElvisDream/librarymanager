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
            }
        });
    }
    adminInfo();
    
    $(".imgDiv").click(function () {
        if($(this).text()=="√") {
            num--
            $(this).text("");
            $("#errorMsg").hide(500);
        }else{
            // alert($(this).find("input").val())//获取书籍名称
            if(num < 4) {
                num++;
                $(this).text("√");
            }else{
                $("#errorMsg").show(500);
            }
        }
    });

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
    userId = "";
    $("#userQuery").click(function () {
        userId = $("#userId").val();
        query(userId);
    });
    function query(userId) {
        $.ajax({
            dataType:"json",
            url:"user.do",
            type:'post',
            data:{userId:userId},
            success:function (result) {
                //此处开始写获取用户信息
                $("#getUserId").text(result.userId);
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
});
