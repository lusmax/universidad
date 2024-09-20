package dbentidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisa
 */
public abstract class DbConnection {
    
    //Datos DB
        private static String url = "jdbc:mysql://localhost";
        private static String DataBase = "universidad";
        private static String user = "root";
        private static String pass = "123456";

    //Métodos
    //MAKE CONNECTION
    public static Connection getConnection() {
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DbConnection.url + "/" + DbConnection.DataBase, DbConnection.user, DbConnection.pass);
            System.out.println("ConnecDataBasetion OK");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    //CLOSE CONNECTION 
    public static String closeConnection(Connection connection) {
        String result;
        try {
            connection.close();
            result = "Connection closed";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't close connection";
        }

        return result;
    }
}
