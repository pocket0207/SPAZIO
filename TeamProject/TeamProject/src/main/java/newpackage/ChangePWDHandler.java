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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 이동현
 */
public class ChangePWDHandler extends HttpServlet {

    Connection conn = null;
    PreparedStatement psmt = null;
    int count = 0;

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

            String PWD1 = request.getParameter("PASSWORD1");
            String PWD2 = request.getParameter("PASSWORD2");
            String ID = FindPWDHandler.userid;
            String PWDrange = "^[a-zA-Z0-9]{5,30}$";

            if (!PWD1.equals(PWD2)) {
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('비밀번호가 일치하지 않습니다!'); window.history.back(); </script>");
                out.println(Popup.toString());
            } else if (!PWD1.matches(PWDrange)) {
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('비밀번호는 5~30자 영문 대소문자, 숫자만 사용 가능합니다!'); window.history.back();</script>");
                out.println(Popup.toString());
            } else {

                Class.forName(DBInfo.JDBC);
                conn = DriverManager.getConnection(DBInfo.URL, DBInfo.ID, DBInfo.PWD);
                String sql = "UPDATE users SET password=? WHERE id=?";
                psmt = conn.prepareStatement(sql);

                psmt.setString(1, utility.getHash(PWD1));
                psmt.setString(2, ID);
                
                count = psmt.executeUpdate();

                if(count >= 1){
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('정상적으로 변경 되었습니다!'); location.href='index.jsp'; </script>");
                out.println(Popup.toString());
                }else{
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('오류가 발생했습니다! - 서버 상태를 확인하세요.'); window.history.back(); </script>");
                out.println(Popup.toString());    
                }
            }
        } catch (Exception e) {
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
