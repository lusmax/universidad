package com.mycompany.universidad;

import dbentidades.DbCarreras;
import dbentidades.DbConnection;
import entidades.*;
import java.sql.SQLException;
import java.util.Scanner;
import ui.MainMenu;

/**
 *
 * @author luisa
 */
public class Universidad {

    public static void main(String[] args) { // probando resolucion de conflitos.
        Scanner scanner = new Scanner(System.in);

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
                String insertCarrera = DbCarreras.insertCarrera(miCarrera);
                System.out.println(insertCarrera);
                break;
            case 2:
                //BUSCAR LA CARRERA A A ACTUALIZAR
                System.out.println("Favor introducir la carrera a actualizar");
                carrera = scanner.nextLine();
                selectedCarrera = DbCarreras.getCarrera(carrera);

                //ACTUALIZAR CARRERA SEGUN BUSQUEDA
                if (selectedCarrera.getCarrera() != null) {
                    System.out.println("Favor introducir el cambio para " + selectedCarrera.getCarrera());
                    carrera = scanner.nextLine();
                    String updatedCarrera = DbCarreras.updateCarrera(carrera, selectedCarrera);
                    System.out.println(updatedCarrera);
                } else {
                    System.out.println("La carrera no fue encontrada");
                }
                break;
            case 3:
                System.out.println("Favor introduzca la carrera a buscar");
                carrera = scanner.nextLine();
                selectedCarrera = DbCarreras.getCarrera(carrera);
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
                selectedCarrera = DbCarreras.getCarrera(carrera);

                //BORRAR CARRERA SEGUN BUSQUEDA
                if (selectedCarrera.getCarrera() != null) {

                    String deleteCarrera = DbCarreras.deleteCarrera(selectedCarrera);
                    System.out.println(deleteCarrera);
                } else {
                    System.out.println("La carrera no fue encontrada");
                }
                break;

            default:
                System.out.println("Introduzca una opcion valida");

        }

        try {

            DbConnection.closeConnection();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Can't close connection");
        }

    }
}
