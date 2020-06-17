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
    
    
    <style>
            body {
                background-image: url("images/backg.jpg");
                background-size: cover;
                color: snow;
            } 

        </style>
        
        
       
    <body>

            <form action="FindIDHandler.do" method="POST" style=" color: #000">
                <center>
                    <table class ="table" style="text-align: start"; border="1" 1px solid background="#dddddd" width="500" height="100" >
                        <br />
                        <strong style=" font-size: 30; color: snow;">- ID 찾기 -</strong><br />
                            <thread><tr>
                                <th width="200" style="background-color: #007bff "; text-align: center;">이름</th>
                                <th><input type='text' name="NAME" style="width: 60%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #0069d9"; text-align: center;">생년월일</th>
                                <th><input type='date' name="BIRTH" style="width: 60%"/></th>
                            </tr>
                            <th style="background-color: #0062cc"; text-align: center;">이메일</th>
                            <th><input type='text' name="EMAIL1" style="width:40%" /> @ <input type='text' name="EMAIL2" style="width: 40%" /></th>
                            </tr>
                            <th style="background-color: #005cbf"; text-align: center;">휴대폰 번호</th>
                            <th><input type='text' maxlength="3" name="TEL1" style="width: 25%" /> - <input type='text' name="TEL2" maxlength="4" style="width: 25%" /> - <input type='text' name="TEL3" maxlength="4" style="width: 25%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #0056b3"; text-align: center;"></th>
                                <th><input type="submit" style=" width: 100%" value="ID 찾기" /></th>
                            </tr>
                        </thread>
                    </tbody></center><br />
            </form>
            
            <form action="FindPWDHandler.do" method="POST" style=" color: white">
                <center>
                    <table class ="table" style="text-align: start"; border="1" 1px solid background="#dddddd" width="500" height="100">
                        <br /><br />
                        <br /><strong style=" font-size: 30; color: whitesmoke" >- PWD 찾기 -</strong><br />
                        <thread><tr>
                                <th width="200" style="background-color: #007bff"; text-align: center;">아이디</th>
                                <th><input type='text' name="NAME" style="width: 60%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #0069d9"; text-align: center;">생년월일</th>
                                <th><input type='date' name="BIRTH" style="width: 60%"/></th>
                            </tr>
                            <th style="background-color: #0062cc"; text-align: center;">이메일</th>
                            <th><input type='text' name="EMAIL1" style="width:40%" /> @ <input type='text' name="EMAIL2" style="width: 40%" /></th>
                            </tr>
                            <th style="background-color: #005cbf"; text-align: center;">휴대폰 번호</th>
                            <th><input type='text' maxlength="3" name="TEL1" style="width: 25%;" /> - <input type='text' name="TEL2" maxlength="4" style="width: 25%" /> - <input type='text' name="TEL3" maxlength="4" style="width: 25%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #0056b3"; text-align: center;"></th>
                                <th><input type="submit" style="width: 100%;" value="PWD 찾기" /></th>
                            </tr>
                        </thread>
                    </tbody><br />
                    
                </center>
                            
            </form>
        <form>
            <center>
                <br/>
                <table>
                    &nbsp; &nbsp; &nbsp; &nbsp;<input type="button" style="margin-top: 20px; width: 15%" value="뒤로가기" onclick="history.back()"/>
                </table>
                
            </center>
        </form>
    </body>
    
</html>
