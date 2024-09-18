package dbentidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisa
 */
public class DbConnection {

    //Métodos
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
}
