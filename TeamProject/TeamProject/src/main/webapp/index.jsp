<%--
    Document   : index.jsp
    Author     : jongmin's DK_ver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그인 화면</title>
        <link type="text/css" rel="stylesheet" href="css/login_style.css" />

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
        <div id="login_form">
            <form method="POST" action="LoginHandler.do"> <!--307p-->
                <h1> Login </h1>
                사용자: <input type="text" name="userid" size="20" placeholder="Username" required> <br />
                암&nbsp;&nbsp;&nbsp;호: <input type="password" name="passwd" size="20" placeholder="Password" required onKeyPress="return checkCapsLock(event)"> <br /> <br />
                <!-- 2020.04.05 placeholder : 텍스트박스 안에 글자 넣기 가능 -->
                <input type="submit" value="로그인" name="B1">&nbsp;&nbsp;&nbsp;
                <input type="reset" value="다시 입력" name="B2">

                <a href="join.jsp"><br>Don't have an account? Register<br></a>
                <h3>2020.04.28 로그인 테스트</h3>
            </form>
        </div>

        <%@include file="footer.jspf"%>
        <%-- <jsp:include page="footer.jspf" /> --%>
    </body>
</html>
