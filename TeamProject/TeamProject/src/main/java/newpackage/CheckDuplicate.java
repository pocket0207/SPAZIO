/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 이동현
 */
public class CheckDuplicate extends HttpServlet {

    String Input = null; // 사용자가 중복체크하기 위해 넣은 아이디
    PrintWriter out;
    public static String USERID;
    public static boolean Check = false;
    String range = "^[a-zA-Z0-9]{5,20}$";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        boolean isOK = false;
        USERID = request.getParameter("ID");
        try {

            String userid = request.getParameter("ID");
            Input = userid;
            isOK = isDuplicate(userid);
            if(isOK && Input.matches(range)){     // 중복검사 통과, 정규표현식 통과
                out.println(CanPopup());
                Check = true;
            }else if(Input.matches(range) == false){ // 정규 표현식에 일치하지 않는다면
                out.println("<script>alert('5~20자의 영문 대소문자,숫자만 사용 가능합니다.'); window.history.back();</script>");
                Check = false;
            }else{
                out.println(CantPopup());
                Check = false;
            }
            out.flush();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    
    public boolean isDuplicate(String userid) {

        boolean isok = false;
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        int count = 999;
      
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://34.64.138.170:3306/capstone?serverTimezone=Asia/Seoul", "capstone", "capstone");
        String sql = "SELECT id FROM users WHERE id=?";
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, Input);
        rs = psmt.executeQuery();
        
        if(rs.next()){                  // 일치하는 ID가 있으면 false를 리턴
            isok = false;
        }else{
            isok = true;
        }
        
        }catch(Exception e){
            System.err.println("데이터베이스 연결 오류! (서버 상태를 확인하세요)");
            System.err.println(e.getMessage());
        }finally{
            try{
            conn.close();
            psmt.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        return isok;
    }

    public String CanPopup() { // 중복체크 팝업(중복된 아이디 없음)
        StringBuilder Popup = new StringBuilder();
        Popup.append("<script>alert('사용할 수 있는 아이디 입니다!'); window.history.back();</script>");
        return Popup.toString();
    }

    public String CantPopup() { // 중복체크 팝업(중복된 아이디 존재)
        StringBuilder Popup = new StringBuilder();
        Popup.append("<script>alert('이미 사용중인 아이디 입니다!'); window.history.back();</script>");
        return Popup.toString();
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
