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
    
    public String _sortby(String plhn,String ascdesc){
        String _sortResult=" ";
        if(plhn.equals("tanggal")){
            _sortResult+= "ORDER BY pesanan.tanggal ";
        } else if(plhn.equals("total biaya")){
            _sortResult+= "ORDER BY pesanan.total_biaya ";
        }
        if(ascdesc.equals("besar ke kecil")){
            _sortResult+= "DESC;";
        } else _sortResult+= "ASC;";
        if(plhn.equals("default")) return ";";
        return _sortResult;
    }
    public ArrayList<History> getBulanIniHistory(String plhn,String ascdesc){
        try {
            plhn = _sortby(plhn,ascdesc);
            ArrayList<History> list = new ArrayList<>();
            sql ="SELECT * FROM pesanan WHERE MONTH(tanggal) = MONTH(CURDATE()) AND YEAR(tanggal) = YEAR(CURDATE())"+plhn;
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
    public ArrayList<History> getMingguIniHistory(String plhn,String ascdesc){
        try {
            plhn = _sortby(plhn,ascdesc);
            ArrayList<History> list = new ArrayList<>();
            sql = "SELECT * FROM pesanan WHERE YEARWEEK(tanggal, 1) = YEARWEEK(CURDATE(), 1)"+plhn;
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
            System.out.println("Query Gagal..."+e);
            return null;
        }
    }
    public ArrayList<History> getAllHistory(String plhn,String ascdesc) {
        try {
            plhn = _sortby(plhn,ascdesc);
            sql = "select * from pesanan"+plhn;
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
            System.out.println("Query Gagal..."+e);
            return null;
        }
    }
}
