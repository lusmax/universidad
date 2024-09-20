package com.mycompany.universidad;

import dbentidades.DbCarreras;
import dbentidades.DbConnection;
import entidades.*;
import java.sql.Connection;
import java.util.Scanner;
import ui.MainMenu;

/**
 *
 * @author luisa
 */
public class Universidad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //CREANDO CONEXION
        Connection miConexion = DbConnection.getConnection();

        // IMPRIMIR EL MENU EN PANTALLA
        String[] menu = MainMenu.getMenu();

        for (String opcion : menu) {
            System.out.println(opcion);
        }

        //VARIABLES
        String carrera;
        Carrera selectedCarrera;

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
            case 2:
                //BUSCAR LA CARRERA A A ACTUALIZAR
                System.out.println("Favor introducir la carrera a actualizar");
                carrera = scanner.nextLine();
                selectedCarrera = DbCarreras.getCarrera(miConexion, carrera);

                //ACTUALIZAR CARRERA SEGUN BUSQUEDA
                if (selectedCarrera.getCarrera() != null) {
                    System.out.println("Favor introducir el cambio para " + selectedCarrera.getCarrera());
                    carrera = scanner.nextLine();
                    String updatedCarrera = DbCarreras.updateCarrera(miConexion, carrera, selectedCarrera);
                    System.out.println(updatedCarrera);
                } else {
                    System.out.println("La carrera no fue encontrada");
                }
                break;
            case 3:
                System.out.println("Favor introduzca la carrera a buscar");
                carrera = scanner.nextLine();
                selectedCarrera = DbCarreras.getCarrera(miConexion, carrera);
                if (selectedCarrera.getCarrera() != null) {
                    System.out.println(selectedCarrera);
                } else {
                    System.out.println("La carrera no fue encontrada");
                }
                break;
                case 4:
                //BUSCAR LA CARRERA A A ACTUALIZAR
                System.out.println("Favor introducir la carrera a borrar");
                carrera = scanner.nextLine();
                selectedCarrera = DbCarreras.getCarrera(miConexion, carrera);

                //BORRAR CARRERA SEGUN BUSQUEDA
                if (selectedCarrera.getCarrera() != null) {
                   
                    String deleteCarrera = DbCarreras.deleteCarrera(miConexion, selectedCarrera);
                    System.out.println(deleteCarrera);
                } else {
                    System.out.println("La carrera no fue encontrada");
                }
                break;

            default:
                System.out.println("Introduzca una opcion valida");

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
        ResultSet selectedCarrera = DbCarreras.getCarrera(miConexion, 2);

        try {
            while (selectedCarrera.next()) {
                System.out.println(selectedCarrera.getString("carrera"));
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
