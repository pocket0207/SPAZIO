/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author 이동현
 */
public class DBInfo {

    public static String ID;
    public static String PWD;
    public static String URL;
    public static String JDBC;

    public static void setting(String path) {

        try {
            Properties props = new Properties();

            Properties session = System.getProperties();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            props.load(bis);
            ID = props.getProperty("id");
            PWD = props.getProperty("pwd");
            URL = props.getProperty("dburl");
            JDBC = props.getProperty("jdbc");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
