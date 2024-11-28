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
    public ArrayList<History> getBulanIniHistory(){
        try {
            ArrayList<History> list = new ArrayList<>();
            sql ="SELECT * FROM pesanan WHERE MONTH(tanggal) = MONTH(CURDATE()) AND YEAR(tanggal) = YEAR(CURDATE());";
            res = stm.executeQuery(sql);
            while (res.next()) {
                History history = new History();
                history.setId(res.getInt("id"));
                history.setDate(res.getDate("tanggal"));
                history.setTotal_biaya(res.getDouble("total_biaya"));
                history.setUser_id(res.getInt("user_id"));
                list.add(history);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Query Gagal... :"+e);
            return null;
        }
    }
    public ArrayList<History> getMingguIniHistory(){
        try {
            ArrayList<History> list = new ArrayList<>();
            sql = "SELECT * FROM pesanan WHERE YEARWEEK(tanggal, 1) = YEARWEEK(CURDATE(), 1);";
            res = stm.executeQuery(sql);
            while (res.next()) {
                History history = new History();
                history.setId(res.getInt("id"));
                history.setDate(res.getDate("tanggal"));
                history.setTotal_biaya(res.getDouble("total_biaya"));
                history.setUser_id(res.getInt("user_id"));
                list.add(history);
            }
            System.out.println("Berhasil dibuat");
            return list;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }
    public ArrayList<History> getAllHistory() {
        try {
            sql = "select * from pesanan";
            res = stm.executeQuery(sql);

            ArrayList<History> historyList = new ArrayList<>();

            while (res.next()) {
                History history = new History();
                history.setId(res.getInt("id"));
                history.setDate(res.getDate("tanggal"));
                history.setTotal_biaya(res.getDouble("total_biaya"));
                history.setUser_id(res.getInt("user_id"));
                historyList.add(history);
            }
            return historyList;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }
}
