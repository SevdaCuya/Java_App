/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

 
import dao.GroupDAO;
import entity.SystemGroup;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sevda.cuya
 */
@Named
@SessionScoped
public class GroupBean implements Serializable {

    private SystemGroup entity;
    private GroupDAO dao;
    private List<SystemGroup> list;

    public GroupBean() {
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new SystemGroup();
    }

    public void clear() {
        this.entity = new SystemGroup();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new SystemGroup();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new SystemGroup();
    }

    public SystemGroup getEntity() {
        if (this.entity == null) {
            this.entity = new SystemGroup();
        }
        return entity;
    }

    public void setEntity(SystemGroup entity) {
        this.entity = entity;
    }

    public  GroupDAO getDao() {
        if (this.dao == null) {
            this.dao = new  GroupDAO();
        }
        return dao;
    }

    public void setDao( GroupDAO dao) {
        this.dao = dao;
    }

    public List<SystemGroup> getList() {
        this.list = this.getDao().readList();
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }

}
