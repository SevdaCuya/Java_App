/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sevda.cuya
 */
public class CategoryDAO extends DBConnection {

    Category c;

    public void create(Category c) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into category (title) values ('" + c.getTitle() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Category c) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update category set title=' " + c.getTitle() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Category c) {

        try {
            Statement st = this.connect().createStatement();
            String query = "delete from category where id= " + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Category> getList() {
        List<Category> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
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
