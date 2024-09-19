package com.mycompany.universidad;

import dbentidades.DbCarreras;
import dbentidades.DbConnection;
import entidades.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import ui.MainMenu;

/**
 *
 * @author luisa
 */
public class Universidad {

    public static void main(String[] args) {
        
        String[] menu = MainMenu.getMenu();
        
        for(String opcion : menu) {
            System.out.println(opcion);
        }
        /* Carreras miCarrera = new Carreras("Historia");

        String url = "jdbc:mysql://localhost";
        String DataBase = "universidad";
        String user = "root";
        String pass = "123456";

        //TESTING CONNECTION TO DATABASE
        Connection miConexion = DbConnection.getConnection(url, DataBase, user, pass);
        
        //TESTING INSERT CARRRERA INTO DATABASE
        //String insertCarrera = DbCarreras.insertCarrera(miConexion, "Informática");
        //System.out.println(insertCarrera);
        
        //TESTING DELETE CARRERA INTO DATABASE
        //String deleteCarrera = DbCarreras.deleteCarrera(miConexion, 1);
        //System.out.println(deleteCarrera);
        

        //TESTING SELECT 
        ResultSet selectCarrera = DbCarreras.getCarrera(miConexion, 2);

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
*/

    }
}
