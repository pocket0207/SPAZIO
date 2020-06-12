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
public class LoginHandler extends HttpServlet {

    Connection conn = null;
    PreparedStatement psmt = null;
    

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
        try (PrintWriter out = response.getWriter()) {
            String InputID = request.getParameter("ID");
            String InputPWD = request.getParameter("PWD");
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://34.64.138.170:3306/capstone?serverTimezone=Asia/Seoul", "capstone", "dlehdgus950831");
                String sql = "SELECT id,password FROM users WHERE id=? and password=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, InputID);
                psmt.setString(2, utility.getHash(InputPWD));
                rs = psmt.executeQuery();

                if (rs.next()) {                  // 일치하는 ID가 있으면 false를 리턴
                    StringBuilder Popup = new StringBuilder();
                    Popup.append("<script>location.href='main.html';</script>");
                    out.println(Popup.toString());
                } else {
                    StringBuilder Popup = new StringBuilder();
                    Popup.append("<script>alert('일치하는 계정이 없습니다!'); window.history.back();</script>");
                    out.println(Popup.toString());
                }

            } catch (Exception e) {
                System.err.println("데이터베이스 연결 오류! (서버 상태를 확인하세요)");
                System.err.println(e.getMessage());
            } finally {
                try {
                    conn.close();
                    psmt.close();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }

        }
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
