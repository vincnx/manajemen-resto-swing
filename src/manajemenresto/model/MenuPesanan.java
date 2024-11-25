/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.model;

/**
 *
 * @author vincentexelcio
 */
public class MenuPesanan {
    private int id;
    private int pesananId;
    private int menuId;
    private Menu menu;
    private int jumlahPesanan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPesananId() {
        return pesananId;
    }

    public void setPesananId(int pesananId) {
        this.pesananId = pesananId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPembelian) {
        this.jumlahPesanan = jumlahPembelian;
    }
    
    
}
