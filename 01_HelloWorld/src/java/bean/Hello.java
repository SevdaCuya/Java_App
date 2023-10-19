/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named; 
import java.io.Serializable;

/**
 *
 * @author sevda.cuya
 */
@Named
@SessionScoped
public class Hello implements Serializable{

   private String mesaj="Selam";
    public Hello() {
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    
}
