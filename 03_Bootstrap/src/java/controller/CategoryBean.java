/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CategoryDao;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 

/**
 *
 * @author sevda.cuya
 */
@Named
@SessionScoped
public class CategoryBean implements Serializable{

    private List<Category> clist;
    private CategoryDao cdao;
    
    
    public CategoryBean() {
        this.cdao=new CategoryDao();
        clist=new ArrayList<Category>();
    }

    public CategoryBean(List<Category> clist, CategoryDao cdao) {
        this.clist = clist;
        this.cdao = cdao;
    }

    public List<Category> getClist() {
        this.clist=this.getCdao().getList();
        return clist;
    }

    public void setClist(List<Category> clist) {
        this.clist = clist;
    }

    public CategoryDao getCdao() {
        return cdao;
    }

    public void setCdao(CategoryDao cdao) {
        this.cdao = cdao;
    }
    
}
