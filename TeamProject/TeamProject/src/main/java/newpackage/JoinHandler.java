package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class JoinHandler extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");

            String ID = CheckDuplicate.USERID;
            String PASSWORD = request.getParameter("PASSWORD");
            String PASSWORD2 = request.getParameter("PASSWORD2");
            String NAME = request.getParameter("NAME");
            String SEX = request.getParameter("SEX");
            String ADDRESS = request.getParameter("ADDRESS");
            String BIRTH = request.getParameter("BIRTH");
            String EMAIL = request.getParameter("EMAIL")+"@"+request.getParameter("EMAIL2");
            String LOCATIONNUMBER = request.getParameter("LOCATION");
            String TEL = request.getParameter("TEL");


            // 이름 정규표현식 만족 여부
            String NAMErange = "^[가-힣a-zA-Z]{2,30}$";
            boolean isMatchedNAMErange = NAME.matches(NAMErange);

            // 비밀번호 1,2 일치 여부, 정규표현식 만족 여부
            boolean isMatched = PASSWORD.equals(PASSWORD2);
            String PWDrange = "^[a-zA-Z0-9]{5,30}$";
            boolean isMatchedPWDrange = PASSWORD.matches(PWDrange);

            // 휴대폰 번호 정규표현식 만족 여부
            String TELrange = "^[0-9]{8}$";  // 3~4자리 숫자만 허용
            
            boolean isMatchedTELrange = TEL.matches(TELrange);
            
            

            if(CheckDuplicate.Check == false) {
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('아이디 중복 여부를 체크하세요!'); window.history.back();</script>");
                out.println(Popup.toString());
            }else if(isMatched == false){
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('비밀번호가 일치하지 않습니다!'); window.history.back();</script>");
                out.println(Popup.toString());
            }else if(isMatchedPWDrange == false){
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('비밀번호는 5~30자 영문 대소문자, 숫자만 사용 가능합니다!'); window.history.back();</script>");
                out.println(Popup.toString());
            }else if(isMatchedNAMErange == false){
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('이름은 2~15자 한글,영문 대소문자만 사용 가능합니다!'); window.history.back();</script>");
                out.println(Popup.toString());
            }else if(isMatchedTELrange == false){
                StringBuilder Popup = new StringBuilder();
                Popup.append("<script>alert('잘못된 휴대폰 번호 형식입니다!'); window.history.back();</script>");
                out.println(Popup.toString());
            }
            else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://34.64.138.170:3306/capstone?serverTimezone=Asia/Seoul", "capstone", "dlehdgus950831");
                    String sql = "Insert INTO users Values(?,?,?,?,?,?,?,?)";
                    psmt = conn.prepareStatement(sql);

                    psmt.setString(1, ID);
                    psmt.setString(2, utility.getHash(PASSWORD));
                    psmt.setString(3, NAME);
                    psmt.setString(4, SEX);
                    psmt.setString(5, ADDRESS);
                    psmt.setString(6, BIRTH);
                    psmt.setString(7, EMAIL);
                    psmt.setString(8,LOCATIONNUMBER+TEL);
                    
                    count = psmt.executeUpdate(); // 업데이트가 성공적으로 되면
                    
                    if(count >= 1){
                    StringBuilder Popup = new StringBuilder();
                    Popup.append("<script>alert('회원가입 성공!'); location.href='index.jsp';</script>");
                    out.println(Popup.toString());
                    }else{
                    StringBuilder Popup = new StringBuilder();
                    Popup.append("<script>alert('회원가입 실패 - 서버 상태를 확인하세요.'); window.history.back();</script>");
                    out.println(Popup.toString());    
                    }
                    

                } catch (Exception e) {
                    System.err.println("데이터 베이스 접속 실패");
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
