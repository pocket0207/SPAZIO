<%-- 
    Document   : find
    Created on : 2020. 5. 27., 오후 9:40:13
    Author     : 이동현
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/011.css" >


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ID / PWD 찾기</title>
        <style type="text/css">

  body { color:#F5ECCE; }
  
  </style>
    </head>
    <style>

        body{
                background-color: ivory;

		background-size : cover;

        }



    </style>
    <body>
<<<<<<< HEAD
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
=======

        
            <form action="FindIDHandler.do" method="POST" style=" color: #000">
                <center>
                    <table class ="table" style="text-align: start"; border="1" 1px solid background="#dddddd" width="500" height="100">
                        <strong style=" font-size: 30">- ID 찾기 -</strong><br />
                            <thread><tr>
                                <th width="200" style="background-color: oldlace"; text-align: center;">이름</th>
                                <th><input type='text' name="NAME" style="width: 60%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #ffdf7e"; text-align: center;">생년월일</th>
                                <th><input type='date' name="BIRTH" style="width: 60%"/></th>
                            </tr>
                            <th style="background-color: gold"; text-align: center;">이메일</th>
                            <th><input type='text' name="EMAIL1" style="width:40%" /> @ <input type='text' name="EMAIL2" style="width: 40%" /></th>
                            </tr>
                            <th style="background-color: yellow"; text-align: center;">휴대폰 번호</th>
                            <th><input type='text' maxlength="3" name="TEL1" style="width: 25%" /> - <input type='text' name="TEL2" maxlength="4" style="width: 25%" /> - <input type='text' name="TEL3" maxlength="4" style="width: 25%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #ffffff"; text-align: center;"></th>
                                <th><input type="submit" style=" width: 100%" value="ID 찾기" /></th>
                            </tr>
                        </thread>
                    </tbody></center><br />

            </form>
        
        
        
            <form action="FindPWDHandler.do" method="POST" style=" color: white">
                <center>
                    <table class ="table" style="text-align: start"; border="1" 1px solid background="#dddddd" width="500" height="100">
                        <br /><br /><br />
                        <br /><strong style=" font-size: 30" >- PWD 찾기 -</strong><br />
                        <thread><tr>
                                <th width="200" style="background-color: oldlace"; text-align: center;">아이디</th>
                                <th><input type='text' name="NAME" style="width: 60%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #ffdf7e"; text-align: center;">생년월일</th>
                                <th><input type='date' name="BIRTH" style="width: 60%"/></th>
                            </tr>
                            <th style="background-color: gold"; text-align: center;">이메일</th>
                            <th><input type='text' name="EMAIL1" style="width:40%" /> @ <input type='text' name="EMAIL2" style="width: 40%" /></th>
                            </tr>
                            <th style="background-color: yellow"; text-align: center;">휴대폰 번호</th>
                            <th><input type='text' maxlength="3" name="TEL1" style="width: 25%" /> - <input type='text' name="TEL2" maxlength="4" style="width: 25%" /> - <input type='text' name="TEL3" maxlength="4" style="width: 25%" /></th>
                            </tr>
                            <tr>
                                <th style="background-color: #ffffff"; text-align: center;"></th>
                                <th><input type="submit" style="width: 100%;" value="PWD 찾기" /></th>
                            </tr>
                        </thread>
                    </tbody></center><br />

            </form>
        

>>>>>>> c2ae62eae1b15facee05abc7e38ae8d81ed0a3f2
    </body>
</html>
