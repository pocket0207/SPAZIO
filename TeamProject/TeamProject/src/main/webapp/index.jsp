<%--
    Document   : index.jsp
    Author     : jongmin's DK_ver
--%>

<%@page import="newpackage.DBInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String path = this.getServletContext().getRealPath(".");
    path += "\\WEB-INF\\classes\\conf\\db.properties";
    DBInfo.setting(path);
%>



<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그인 화면</title>

        <style>
            body {
                background-image: url("images/backg.jpg");
                background-size: cover;
                color: snow;
            } 

        </style>
        
        
        
        <link type="text/css" rel="stylesheet" href="css/login_style.css" />
        <link type="text/css" rel="stylesheet" href="css/table_style.css" />

        <script type="text/javascript">
            function checkCapsLock(e) {

                var myKeyCode = 0;
                var myShiftKey = false;
                var myMsg = 'Caps Lock를 누른 상태에서는 비밀번호를 입력하실 수 없습니다. Caps Lock을 해제해주세요.';

                if (document.all) {
                    myKeyCode = e.keyCode;
                    myShiftKey = e.shiftKey;
                    // Netscape 4
                } else if (document.layers) {
                    myKeyCode = e.which;
                    myShiftKey = (myKeyCode == 16) ? true : false;
                    // Netscape 6
                } else if (document.getElementById) {
                    myKeyCode = e.which;
                    myShiftKey = (myKeyCode == 16) ? true : false;
                }
                if ((myKeyCode >= 65 && myKeyCode <= 90) && !myShiftKey) {
                    alert(myMsg);
                    return false;

                } else if ((myKeyCode >= 97 && myKeyCode <= 122) && myShiftKey) {
                    alert(myMsg);
                    return false;
                }
            }
        </script>

    </head>
    <body>

        <div id="login_form"style="width: 30%; margin-left: 35%; margin-right: 35%;">
            <form method="POST" action="LoginHandler.do"> <!--307p-->
                <h1> Login </h1><br />
                사용자: <input type="text" name="ID" size="20" placeholder="Username" required> <br />
                암&nbsp;&nbsp;&nbsp;호: <input type="password" name="PWD" size="20" placeholder="Password" required onKeyPress="return checkCapsLock(event)"> <br /> <br />
                <!-- 2020.04.05 placeholder : 텍스트박스 안에 글자 넣기 가능 -->
                <input type="submit" value="로그인" name="B1" >&nbsp;&nbsp;&nbsp;
                <input type="reset" value="다시 입력" name="B2">

                <a href="join.jsp" style=" color: salmon"><center><br>Don't have an account? Register<br></center></a><br />

                <a href="find.jsp" style=" color: turquoise"><input type="button" value="ID / PWD 찾기" onclick=; /></a>

            </form>
        </div>
        <br />
        <br />
        <br />
    
        <%@include file="footer.jspf"%>
        <%-- <jsp:include page="footer.jspf" /> --%>
    </body>
</html>
