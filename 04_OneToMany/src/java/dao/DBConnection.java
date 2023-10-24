/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sevda.cuya
 */
public abstract class DBConnection {

    private Connection connection;

    public Connection getConnection() {
        if (this.connection == null) {

            try {
                Class.forName("org.postgresql.Driver");
                this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/blog", "postgres", "admin");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
