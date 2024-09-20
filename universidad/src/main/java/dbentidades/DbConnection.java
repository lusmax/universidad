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
        private static final String URL = System.getenv("DB_URL_PRUEBA");
        private static final String DATABASE = System.getenv("DB_PRUEBA");
        private static final String USER = System.getenv("DB_USER_PRUEBA");
        private static final String PASS = System.getenv("DB_PASS_PRUEBA");

    //Métodos
    //MAKE CONNECTION
    public static Connection getConnection() {
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DbConnection.URL + "/" + DbConnection.DATABASE, DbConnection.USER, DbConnection.PASS);
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
