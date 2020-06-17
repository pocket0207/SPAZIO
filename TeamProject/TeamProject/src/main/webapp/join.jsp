<%-- 
    Document   : add_user.jsp
    Author     : jongmin's DK_ver
--%>

<%@page import="newpackage.PhoneAuthentication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <body scroll=auto style="overflow-x:hidden">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>사용자 추가 화면</title>

        <link type="text/css" rel="stylesheet" href="css/login_style.css" />
        <link type="text/css" rel="stylesheet" href="css/table_style.css" />
        
        <script type="text/javascript">

            function getConfirmResult() {
                var result = confirm("위 정보로 회원가입을 하시겠습니까?");
                return result;
            }
            
            function test(){
                
                var test2 = document.getElementById('TEL').value;
   
                return test2;
            }

            function isSame() {
                if (pw.length < 1 || pw.length > 16) {
                    document.getElementById('pw').value=document.getElementById('pwCheck').value='';
                    document.getElementById('same').innerHTML=''
                }
                if(document.getElementById('pw').value!='' && document.getElementById('pwCheck').value!='') {
                    if(document.getElementById('pw').value==document.getElementById('pwCheck').value) {
                        document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
                        document.getElementById('same').style.color='blue';
                    }
                    else {
                        document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다. 다시 확인해주세요.';
                        document.getElementById('same').style.color='red';
                    }
                }
            }
        </script>
        
    </head>
    <jsp:include page="header.jsp" />
    <div id="sidebar">
        <%--        <jsp:include page="sidebar_admin_previous_menu.jsp" />--%>
    </div>
    <div id="main" style="width: 50%; margin-left: 25%; margin-right: 25%;">
        <%--스크롤 페이지 추가 : style:overflow--%>
        <div style="text-align:right;">
            추가로 등록할 사용자 ID와 암호를 입력해 주시기 바랍니다. &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <br> <br>
        </div>

        <table border="0" style="align-content: center">
            <tr>
                <td>사용자 ID </td>
            <form action="CheckDuplicate.do" method="POST">
                <td> <input type="text" name="ID" value="" size="30" placeholder="ID입력" maxlength="30" required><td><input type="submit" value="중복확인"></td>
            </form>
            </tr>

            <form action="JoinHandler.do" method="POST">
                <tr>
                    <td>비밀번호 </td>
                    <td> <input type="password" name="PASSWORD" value="" size="25" placeholder="비밀번호(5자이상)" maxlength="20" id="pw" onchange="isSame()" required/> </td>
                </tr>
                <tr>                 
                    <td>비밀번호 확인 </td>
                    <td> <input type="password" name="PASSWORD2" id="pwCheck" onchange="isSame()" value="" size="25" placeholder="비밀번호 확인" maxlength="15" required/> </td>
                <br> <span id="same"></span> </td>
                </tr>
                <tr>
                    <td>이름 </td>
                    <td> <input type="text" name="NAME" value="" size="25" placeholder="이름" required/> </td>
                </tr>

                <tr>
                    <td>성별 </td>
                    <td> <input type='radio' name='SEX' value='FEMALE' required />여성
                        <input type='radio' name='SEX' value='MALE' required />남성 </td>
                </tr>
                <tr>
                    <td>주소 </td>
                    <td> <input type="text" name="ADDRESS" value="" size="25" required />  </td>
                </tr>

                <tr>
                    <td>생년월일 </td>
                    <td> <input type="date" name="BIRTH" value="" size="25" required/> </td>
                </tr>
                <tr>
                    <td>이메일 </td>
                    <td> <input type="text" size="10" name="EMAIL" required>@<input type="text" size="10" name="EMAIL2" placeholder="직접입력" required>
                    </td>
                </tr>    

                <tr>
                    <td>휴대폰 번호 </td>
                    <td valgn="top">
                        <select name="LOCATION" size="">
                            <option value="010">010</option>
                            <option value="011">011</option>   
                        </select>
                    <input type="tel" name="TEL" id="TEL" value="" size="10" placeholder="하이픈 - 없이 입력하세요!" maxlength="8" required/><td><input type="button" value="인증요청" size="25" onclick="location.href='authentication.jsp?phone='+test()+''" required/> </td></td>
                </tr>

                <tr>
                    <td>휴대폰 인증 </td>
                    <td> <input type="text" name="inputnumber" value="" size="25" required/> </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="submit" value="가입신청"/>
                        <input type="reset" value="초기화" name="reset" />
                        <input type="button" value="뒤로가기" onclick="history.back()"/>
                    </td>
            </form>

        </table>


    </div>

    <jsp:include page="footer.jsp" />

</body>
</html>
