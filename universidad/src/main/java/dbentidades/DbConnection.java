package dbentidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisa
 */
public abstract class DbConnection {

    //Métodos
    //MAKE CONNECTION
    public static Connection getConnection(String url, String DataBase, String user, String pass) {
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url + "/" + DataBase, user, pass);
            System.out.println("Connection OK");

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
