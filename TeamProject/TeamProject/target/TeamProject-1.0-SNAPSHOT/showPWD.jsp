<%-- 
    Document   : showPWD
    Created on : 2020. 5. 27., 오후 11:16:06
    Author     : 이동현
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PWD 찾기</title>
    </head>
    <body>
        <form action="ChangePWDHandler.do" method="POST">
            <center>
                새로 변경할 비밀번호 : <input type="password" name='PASSWORD1'><br />
                비밀번호 확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:  <input type="password" name='PASSWORD2'><br /><br />
                <input type='submit' value="변경하기" style='width: 25%'/>
            </center>
        </form>
    </body>
</html>
