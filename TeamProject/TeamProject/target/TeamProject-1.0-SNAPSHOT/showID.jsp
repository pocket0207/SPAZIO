<%-- 
    Document   : showID
    Created on : 2020. 5. 27., 오후 10:49:46
    Author     : 이동현
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ID 찾기</title>
    </head>
    <body>

    <center>회원님의 아이디는 : <strong><%=request.getParameter("id")%></strong> 입니다.</center><br /> <br />
    <center><input type="button" value="이전으로" onclick="history.back()" style="width: 30%"/><br />
        <input type="button" value="메인으로" onclick="location.href='index.jsp'" style="width: 30%"/></center>
    </body>
</html>
