/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PostDAO;
import entity.Post;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sevda.cuya
 */
@Named(value = "postBean")
@SessionScoped
public class PostBean implements Serializable {

    /**
     * Creates a new instance of PostBean
     */
    private Post entity;
    private PostDAO dao;
    private List<Post> list;

    public PostBean() {

    }

    public void create() {
        this.getDao().create(entity);
        entity = new Post();
    }
    public void clear() { 
        entity = new Post();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Post();
    }

    public void delete(Post c) {
        this.getDao().delete(c);
        entity = new Post();
    }

    public Post getEntity() {
        if (entity == null) {
            entity = new Post();
        }

        return entity;
    }

    public void setEntity(Post entity) {
        this.entity = entity;
    }

    public PostDAO getDao() {
        if (dao == null) {
            dao = new PostDAO();
        }
        return dao;
    }

    public void setDao(PostDAO dao) {
        this.dao = dao;
    }

    public List<Post> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Post> list) {
        this.list = list;
    }

}
