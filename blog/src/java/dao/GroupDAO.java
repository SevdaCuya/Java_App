/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SystemGroup;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author sevda.cuya
 */
public class GroupDAO extends DBConnect {

    public List<SystemGroup> readList() {

        List<SystemGroup> list = new ArrayList();

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from systemgroup");

            while (rs.next()) {
                list.add(new SystemGroup(rs.getLong("id"), rs.getString("gname"),rs.getDate("created"),rs.getDate("updated")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(SystemGroup c) {

        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into systemgroup(gname) values ('"+c.getGname()+"')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(SystemGroup c) {

        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update systemgroup set gname ='"+c.getGname()+"' where id= '"+c.getId()+"'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(SystemGroup c) {

        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from systemgroup where id= '"+c.getId()+"'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
