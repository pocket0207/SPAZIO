<%-- 
    Document   : authentication
    Created on : 2020. 6. 17., 오후 3:51:07
    Author     : 민뚜
--%>

<%@page import="newpackage.SMS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String number = request.getParameter("phone");
    String number2 = "010";
    SMS cl = new SMS();
        try {
            
            cl.Message(number2+number);
            // 입력 받는 부분

        } catch (Exception e) {
            e.printStackTrace();
        }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
            
            alert('인증요청 되었습니다!');
            window.history.back();
        </script>

    </body>
</html>
