/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenresto.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import manajemenresto.model.User;

/**
 *
 * @author vincentexelcio
 */
public class UserController {
    Statement stm;
    ResultSet res;
    String sql;

    public UserController() {
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
    }

    public User cekLogin(String username, String password) {
        try {
            sql = "select * from user where username ='" + username + "' and password ='" + password + "'";

            this.res = stm.executeQuery(sql);

            // username atau password salah
            if (!res.next()) {
                return null;
            }

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(res.getString("role"));
            return user;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }

    public boolean createUser(String username, String noTelp, String password) {
        try {
            sql = "insert into user (username,no_telp,password) values ('" + username + "','" + noTelp + "','"
                    + password + "')";

            int response = stm.executeUpdate(sql);

            return response > 0;
        } catch (Exception e) {
            System.out.println("Query gagal...");
            return false;
        }
    }

    public ArrayList<User> getAllUser() {
        try {
            sql = "select * from user";
            res = stm.executeQuery(sql);

            ArrayList<User> userList = new ArrayList<>();

            while (res.next()) {
                User user = new User();
                user.setUsername(res.getString("username"));
                user.setNoTelp(res.getString("no_telp"));
                user.setPassword(res.getString("password"));
                user.setRole(res.getString("role"));
                userList.add(user);
            }

            return userList;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }

    public User getUserByUsername(String username) {
        try {
            sql = "select * from user where username='" + username + "'";
            res = stm.executeQuery(sql);

            // user tidak ditemukan
            if (!res.next()) {
                return null;
            }

            User user = new User();
            user.setUsername(res.getString("username"));
            user.setNoTelp(res.getString("no_telp"));
            user.setPassword(res.getString("password"));
            user.setRole(res.getString("role"));
            return user;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return null;
        }
    }

    public boolean updateUserByUsername(String username, User dataUserBaru) {
        try {
            sql = "update user set username='" + dataUserBaru.getUsername() + "', no_telp='" + dataUserBaru.getNoTelp()
                    + "', role='" + dataUserBaru.getRole() + "', password='" + dataUserBaru.getPassword()
                    + "' where username='" + username + "'";
            int response = stm.executeUpdate(sql);
            return response > 0;
        } catch (Exception e) {
            System.out.println("Query Gagal...");
            return false;
        }
    }
    
    public boolean deleteUserByUsername(String username) {
        try {
            sql = "delete from user where username='" + username + "'";
            int response = stm.executeUpdate(sql);
            return response > 0;
        } catch (Exception e) {
            System.out.println("Query gagal...");
            return false;
        }
    }
}
