/**
 * Created by Elivs on 2017/3/18.
 */
var num=0;
$(function () {
    $(".imgDiv").click(function () {
        if($(this).text()=="√") {
            num--
            $(this).text("");
            $("#errorMsg").hide(500);
        }else{
//                   alert($(this).find("input").val())//获取书籍名称
            if(num < 4) {
                num++;
                $(this).text("√");
            }else{

                $("#errorMsg").show(500);
            }
        }
    });
});
