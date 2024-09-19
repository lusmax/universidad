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
        String pass = "root";

        //CREANDO CONEXION
        Connection miConexion = DbConnection.getConnection(url, DataBase, user, pass);

        // IMPRIMIR EL MENU EN PANTALLA
        String[] menu = MainMenu.getMenu();

        for (String opcion : menu) {
            System.out.println(opcion);
        }

        //VARIABLES
        String carrera;

        // SOLICITAR OPCION DEL MENU
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Favor introduzca la carrera a insertar");
                carrera = scanner.nextLine();
                Carrera miCarrera = new Carrera(carrera);

                //INSERT CARRRERA INTO DATABASE
                String insertCarrera = DbCarreras.insertCarrera(miConexion, miCarrera);
                System.out.println(insertCarrera);
                break;
            case 3:
                System.out.println("Favor introduzca la carrera a buscar");
                carrera = scanner.nextLine();
                ResultSet selectCarrera = DbCarreras.getCarrera(miConexion, carrera);

                try {
                    while (selectCarrera.next()) {
                        System.out.print("Carrera: ");
                        System.out.print(selectCarrera.getString("carrera"));
                        System.out.print(" ID: ");
                        System.out.println(selectCarrera.getString("idcarrera"));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;

            default:
                System.out.println("Introuzca una opcion valida");

        }

        /* Carrera miCarrera = new Carrera("Historia");

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
