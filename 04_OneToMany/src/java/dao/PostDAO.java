/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
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
    Category a;
    CategoryDAO categoryDao;

    public void create(Post c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into post (category_id,title,context) values (" + c.getCategory().getId() + ",'" + c.getTitle() + "','" + c.getContext() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Post c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update post set category_id=' " + c.getCategory().getId() + "', title='" + c.getTitle() + "' , context='" + c.getContext() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Post c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from post where id= " + c.getId();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Post> getList() {
        List<Post> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from post";
            ResultSet rs = st.executeQuery(query);
           
            while (rs.next()) {
                 a = this.getCategoryDao().findById(rs.getInt("category_id"));
                list.add(new Post(rs.getInt("id"),a , rs.getString("title"), rs.getString("context")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public CategoryDAO getCategoryDao() {
        if(categoryDao==null){
        categoryDao=new CategoryDAO();
        }
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }
}
