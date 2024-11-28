/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.controller;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import manajemenresto.model.History;

/**
 *
 * @author anr00
 */
public class HistoryController {
    Statement stm;
    ResultSet res;
    String sql;

    public HistoryController() {
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
    }
    public ArrayList<History> getAllHistory() {
        try {
            sql = "select * from 'pesanan'";
            res = stm.executeQuery(sql);

            ArrayList<History> pesananList = new ArrayList<>();

            while (res.next()) {
                History pesanan = new History();
                pesanan.setId(res.getInt("id"));
                pesanan.setDate(res.getDate("tanggal"));
                pesanan.setTotal_biaya(res.getDouble("total_biaya"));
                pesanan.setUser_id(res.getInt("user_id"));
                pesananList.add(pesanan);
            }
            return pesananList;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }
}
