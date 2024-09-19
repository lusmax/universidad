package com.mycompany.universidad;

import dbentidades.DbCarreras;
import dbentidades.DbConnection;
import entidades.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import ui.MainMenu;

/**
 *
 * @author luisa
 */
public class Universidad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Datos DB
        String url = "jdbc:mysql://localhost";
        String DataBase = "universidad";
        String user = "root";
        String pass = "123456";

        //CREANDO CONEXION
        Connection miConexion = DbConnection.getConnection(url, DataBase, user, pass);

        // IMPRIMIR EL MENU EN PANTALLA
        String[] menu = MainMenu.getMenu();

        for (String opcion : menu) {
            System.out.println(opcion);
        }

        // SOLICITAR OPCION DEL MENU
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Favor introduzca la carrera");
                String carrera = scanner.nextLine();
                Carreras miCarrera = new Carreras(carrera);

                //INSERT CARRRERA INTO DATABASE
                String insertCarrera = DbCarreras.insertCarrera(miConexion, carrera);
                System.out.println(insertCarrera);
                break;
            default:
                System.out.println("Introuzca una opcion valida");
            
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
