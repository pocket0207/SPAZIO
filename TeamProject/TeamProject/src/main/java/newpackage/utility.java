/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.security.MessageDigest;

/**
 *
 * @author 이동현
 */
public class utility {
    
    public static String getHash(String input) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(input.getBytes());
			byte bytes[] = md.digest();
			for(int i = 0; i<bytes.length; i++) {
				result.append(
						Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
    
}
