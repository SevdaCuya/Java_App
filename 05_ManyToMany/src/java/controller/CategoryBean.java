/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sevda.cuya
 */
@Named(value = "categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

    /**
     * Creates a new instance of CategoryBean
     */
    private Category entity;
    private CategoryDAO dao;
    private List<Category> list;

    public CategoryBean() {

    }

    public void clear() {
        entity = new Category();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Category();
    }

      public String getTitle(int id) {
       Category c = this.getDao().findById(id);
        return c.getTitle();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Category();
    }

    public void delete(Category c) {
        this.getDao().delete(c);
        entity = new Category();
    }

    public Category getEntity() {
        if (entity == null) {
            entity = new Category();
        }

        return entity;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public CategoryDAO getDao() {
        if (dao == null) {
            dao = new CategoryDAO();
        }
        return dao;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    public List<Category> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }

}
