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

 
    CategoryDAO categoryDao;

    public void create(Post c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into post (title,context) values ('" + c.getTitle() + "','" + c.getContext() + "')";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(id) as mid from post");
            rs.next();

            int post_id = rs.getInt("mid");
            for (Category cat : c.getCategories()) {
                query = "insert into post_category (post_id,category_id) values (" + post_id + "," + cat.getId() + ")";
                st.executeUpdate(query);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Post c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "update post set title='" + c.getTitle() + "' , context='" + c.getContext() + "'where id=" + c.getId();
            st.executeUpdate(query);

            st.executeUpdate("delete from post_category where post_id=" + c.getId());

            for (Category cat : c.getCategories()) {
                query = "insert into post_category (post_id,category_id) values (" + c.getId() + "," + cat.getId() + ")";
                st.executeUpdate(query);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Post c) {

        try {
            Statement st = this.getConnection().createStatement();            
            st.executeUpdate("delete from post_category where post_id=" + c.getId());
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
                list.add(new Post(rs.getInt("id"), this.getPostCategories(rs.getInt("id")), rs.getString("title"), rs.getString("context")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public List<Category> getPostCategories(int post_id) {
        List<Category> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from category where id in(select category_id from post_category where post_id="+post_id+")";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Category(rs.getInt("id"), rs.getString("title")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public CategoryDAO getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDAO();
        }
        return categoryDao;
    }

    public void setCategoryDao(CategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }
}
