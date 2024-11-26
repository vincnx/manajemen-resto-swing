/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import manajemenresto.model.Menu;

/**
 *
 * @author vincentexelcio
 */
public class MenuController {
    Statement stm;
    ResultSet res;
    String sql;

    public MenuController() {
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
    }

    public boolean CreateMenu(String namaMenu, double harga) {
        try {
            sql = "insert into menu (nama,harga) values ('" + namaMenu + "'," + harga + ")";

            int response = stm.executeUpdate(sql);

            return response > 0;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return false;
        }
    }

    public ArrayList<Menu> getAllMenu() {
        try {
            sql = "select * from menu";
            res = stm.executeQuery(sql);

            ArrayList<Menu> menuList = new ArrayList<>();

            while (res.next()) {
                Menu menu = new Menu();
                menu.setId(res.getInt("id"));
                menu.setNama(res.getString("nama"));
                menu.setHarga(res.getDouble("harga"));
                menuList.add(menu);
            }

            return menuList;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }

    public Menu getMenuByNama(String nama) {
        try {
            sql = "select * from menu where nama='" + nama + "'";
            res = stm.executeQuery(sql);
            
            if (!res.next()) {
                return null;
            }

            Menu menu = new Menu();
            menu.setId(res.getInt("id"));
            menu.setNama(res.getString("nama"));
            menu.setHarga(res.getDouble("harga"));
            return menu;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }

    public boolean updateMenuByNama(String nama, Menu dataMenuBaru) {
        try {
            sql = "update menu set nama='" + dataMenuBaru.getNama() + "', harga=" + dataMenuBaru.getHarga() + " where nama='" + nama + "'";
            int response = stm.executeUpdate(sql);
            return response > 0;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return false;
        }
    }

    public boolean deleteMenuByNama(String nama) {
        try {
            sql = "delete from menu where nama='" + nama + "'";
            int response = stm.executeUpdate(sql);
            return response > 0;
        } catch (Exception e) {
            System.out.println("Query gagal...");
            return false;
        }
    }
}
