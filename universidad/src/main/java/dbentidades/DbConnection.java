package dbentidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; //CONSIDERAR USAR PreparedStatement

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
    
    //CONEXION DB
    private static final Connection CONNECTION = DbConnection.getConnection();
    

    //Métodos
    //MAKE CONNECTION
    private static Connection getConnection() { //Considerar hacer private el metodo
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DbConnection.URL + "/" + DbConnection.DATABASE, DbConnection.USER, DbConnection.PASS);
            System.out.println("Data Base Connection OK");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    //CLOSE CONNECTION 
    public static void closeConnection() throws SQLException {
        DbConnection.CONNECTION.close();

    }

    //GET STATEMENT
    static Statement getStatement() { //cosiderar hacer default el método
        Statement statement = null;

        try {
            statement = CONNECTION.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return statement;
    }
}
