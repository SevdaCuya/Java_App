/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sevda.cuya
 */
public class CategoryDao {

    public List<Category> getList() {
        List<Category> list = new ArrayList<>();
        DBConnection db = new DBConnection();
        Connection c = db.connect();
        try {
            Statement st = c.createStatement();
            String query = "select * from category";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Category(rs.getInt("id"), rs.getString("title")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
 

}
