/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CategoryDAO;
import entity.Category;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author sevda.cuya
 */
@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {

    private CategoryDAO categoryDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        int id = Integer.parseInt(string);
        Category c = this.getCategoryDao().findById(id);
        return c;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Category c = (Category) t;
        return String.valueOf(c.getId());
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
