/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.model;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 *
 * @author vincentexelcio
 */
public class Pesanan {
    protected int id;
    protected int userId;
    protected User user;
    protected ArrayList<MenuPesanan> menuPesananList;
    protected double totalBiaya;
    protected LocalDateTime tanggal;

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<MenuPesanan> getMenuPesananList() {
        return menuPesananList;
    }

    public void setMenuPesananList(ArrayList<MenuPesanan> menuPesananList) {
        this.menuPesananList = menuPesananList;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }
    
    
}
