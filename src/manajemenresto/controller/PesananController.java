/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import manajemenresto.model.MenuPesanan;

/**
 *
 * @author vincentexelcio
 */
public class PesananController {
    Statement stm;
    ResultSet res;
    String sql;

    public PesananController() {
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
    }
    
    public boolean CreatePesanan(int userId, ArrayList<MenuPesanan> menuPesananList, double totalBiaya) {
        int pesananId;
        try {
            sql = "insert into pesanan (user_id, total_biaya) values (" + userId + ", " + totalBiaya + ")";
            stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            res = stm.getGeneratedKeys();
            if (!res.next()) {
                return false;
            }
            pesananId = res.getInt(1);
            
            System.out.println("2");
            for (MenuPesanan menuPesanan : menuPesananList) {
                sql = "insert into menu_pesanan (pesanan_id, menu_id, jumlah_pesanan) values (" + pesananId + ", " 
                      + "(select id from menu where nama='" + menuPesanan.getMenu().getNama() + "'), " + menuPesanan.getJumlahPesanan() + ")";
                stm.executeUpdate(sql);
            }
            
            return true;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return false;
        }
    }
    
}
