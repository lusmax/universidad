package dbentidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ronar
 */
public abstract class DbCarreras {

    //Métodos
    //SELECT
    public static ResultSet getCarrera(Connection connection, int idcarrera) {
        ResultSet result = null;
        String sql = "SELECT * FROM carreras "
                + "WHERE idcarrera = " + idcarrera;

        try {
            Statement st = connection.createStatement();
            result = st.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    //INSERT
    public static String insertCarrera(Connection connection, String carrera) {
        String result;
        String sql = "INSERT INTO carreras (carrera)"
                + " VALUES (" + carrera + ")";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            result = "New register inserted";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't insert register";
        }
        return result;
    }

    //UPDATE
    public static String updateCarrera(Connection connection, String carrera, int idcarrera) {
        String result;
        String sql = "UPDATE carreras "
                + "SET carrera = " + carrera
                + " WHERE (idcarrera = " + idcarrera + ")";

        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            result = "New register updated";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't update register";
        }
        return result;
    }

}
