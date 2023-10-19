/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Post;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sevda.cuya
 */
public class PostDAO extends DBConnection {

    Post c;

    public void create(Post c) {
        try {
            Statement st = this.connect().createStatement();
            String query = "insert into post (category_id,title,context) values (" + c.getCategory_id() + ",'" + c.getTitle() + "','" + c.getContext() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Post c) {

        try {
            Statement st = this.connect().createStatement();
            String query = "update post set category_id=' " + c.getCategory_id() + "', title=' " + c.getTitle() + " , context=' " + c.getContext() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Post c) {

        try {
            Statement st = this.connect().createStatement();
            String query = "delete from post where id= " + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Post> getList() {
        List<Post> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from post";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Post(rs.getInt("id"), rs.getInt("category_id"), rs.getString("title"), rs.getString("context")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
}
