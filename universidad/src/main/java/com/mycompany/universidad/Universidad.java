package com.mycompany.universidad;

import dbentidades.DbCarreras;
import dbentidades.DbConnection;
import entidades.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String pass = "root";

        //TESTING CONNECTION TO DATABASE
        Connection miConexion = DbConnection.getConnection(url, DataBase, user, pass);

        //TESTING SELECT 
        ResultSet selectCarrera = DbCarreras.getCarrera(miConexion, 0);

        try {
            while (selectCarrera.next()) {
                System.out.println(selectCarrera.getString("carrera"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //TESTING TO CLOSE CONNECTION
        String closeConnection = DbConnection.closeConnection(miConexion);
        System.out.println(closeConnection);

    }
}
