/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author 민뚜
 */
public class PhoneAuthentication {
    
    public static void Authentication(){
        SMS cl = new SMS();
        try {
            
            cl.Message("01032042646");
            // 입력 받는 부분

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
