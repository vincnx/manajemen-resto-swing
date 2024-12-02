/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 *
 * @author vincentexelcio
 */
public class Koneksi {
    //  deklarasi string connection: url, user, password dari db
    public static Connection con;
    public static Statement stm;
    
    public void config() {
        try {
            String url = "jdbc:mysql://localhost/manajemen_resto";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //  merangkai string connection          
            con = DriverManager. getConnection(url, user, pass);
            //  membuat sql statement
            stm = (Statement) con.createStatement();
            
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal...");
        }
    }
}
