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
public class FindPWDHandler extends HttpServlet {

    Connection conn = null;
    PreparedStatement psmt = null;
    int count = 0;
    ResultSet rs = null;
    public static String userid = null;
    
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
            /* TODO output your page here. You may use following sample code. */
            
            request.setCharacterEncoding("UTF-8");
            String ID = request.getParameter("NAME");
            String Birth = request.getParameter("BIRTH");
            String Email = request.getParameter("EMAIL1") + "@" + request.getParameter("EMAIL2");
            String Tel = request.getParameter("TEL1") + request.getParameter("TEL2") + request.getParameter("TEL3");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://34.64.138.170:3306/capstone?serverTimezone=Asia/Seoul", "capstone", "dlehdgus950831");
            String sql = "SELECT id FROM users WHERE id=? and birth=? and email=? and tel=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, ID);
            psmt.setString(2, Birth);
            psmt.setString(3, Email);
            psmt.setString(4, Tel);
            rs = psmt.executeQuery();
            
            if (rs.next()) {                  // 일치하는 ID가 있으면 false를 리턴
                    response.sendRedirect("showPWD.jsp");
                    userid = ID;
                } else {
                    StringBuilder Popup = new StringBuilder();
                    Popup.append("<script>alert('입력한 정보와 일치하는 계정이 없습니다!'); window.history.back(); </script>");
                    out.println(Popup.toString());
                    System.err.println(ID);
                    System.err.println(Birth);
                    System.err.println(Email);
                    System.err.println(Tel);
                    
                }
            
        }catch(Exception e){
            System.err.println(e.getMessage());
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
