<%-- 
    Document   : find
    Created on : 2020. 5. 27., 오후 9:40:13
    Author     : 이동현
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ID / PWD 찾기</title>
    </head>
    <body>
        <form action="FindIDHandler.do" method="POST">
            <center><strong>- ID 찾기 -</strong></center><br />

            <center>이름 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;: <input type='text' name="NAME" style="width: 12%" /><br /></center><br />
            <center>생년월일&nbsp;&nbsp;&nbsp;&nbsp;: <input type='date' name="BIRTH" style="width: 12%"/><br /></center><br />
            <center>이메일&nbsp;&nbsp; &nbsp; &nbsp;  : <input type='text' name="EMAIL1" style="width: 5%" /> @ <input type='text' name="EMAIL2" style="width: 5%" /><br /></center><br />
            <center>휴대폰번호 : <input type='text' maxlength="3" name="TEL1" style="width: 3%" /> - <input type='text' name="TEL2" maxlength="4" style="width: 3%" /> - <input type='text' name="TEL3" maxlength="4" style="width: 3%" /><br /></center> <br/>
            <center><input type="submit" style="width: 20%" value="ID 찾기" /></center>
        </form>
        <br /><br /><br />

        <hr>

        <form action="FindPWDHandler.do" method="POST">
            <center><strong>- PWD 찾기 -</strong></center><br />
            <center>아이디&nbsp;&nbsp; &nbsp; &nbsp; : <input type='text' name="ID" style="width: 12%" /><br /></center><br />
            <center>생년월일&nbsp;&nbsp;&nbsp;&nbsp;: <input type='date' name="BIRTH" style="width: 12%"/><br /></center><br />
            <center>이메일&nbsp;&nbsp; &nbsp; &nbsp;  : <input type='text' name="EMAIL1" style="width: 5%" /> @ <input type='text' name="EMAIL2" style="width: 5%" /><br /></center><br />
            <center>휴대폰번호 : <input type='text' name="TEL1" style="width: 3%" /> - <input type='text' name="TEL2" style="width: 3%" /> - <input type='text' name="TEL3" style="width: 3%" /><br /></center> <br/>
            <center><input type="submit" style="width: 20%" value="PWD 찾기" /></center>
        </form>
    </body>
</html>
