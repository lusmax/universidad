package com.mycompany.universidad;
import dbentidades.DbConnection;
import entidades.*;
import java.sql.Connection;

/**
 *
 * @author luisa
 */
public class Universidad {

    public static void main(String[] args) {
       Carreras miCarrera = new Carreras("Historia");
       
       String url = "jdbc:mysql://localhost";
       String DataBase = "universidad";
       String user = "root";
       String pass = "123456";
       
        
        Connection miConexion = DbConnection.getConnection(url, DataBase, user, pass);
        
        String closeConnection = DbConnection.closeConnection(miConexion);
        System.out.println(closeConnection);
       
    }
}
