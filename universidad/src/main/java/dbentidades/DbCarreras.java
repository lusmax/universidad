package dbentidades;

import entidades.Carrera;
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
    public static ResultSet getCarrera(Connection connection, String carrera) {
        ResultSet result = null;
        String sql = "SELECT * FROM carreras "
                + "WHERE carrera LIKE '" + carrera +  "'";

        try {
            Statement st = connection.createStatement();
            result = st.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    //INSERT
    public static String insertCarrera(Connection connection, Carrera miCarrera) {
        String result;
        String sql = "INSERT INTO carreras (carrera)"
                + " VALUES ('" + miCarrera.getCarrera() + "')";
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

    //DELETE 
    public static String deleteCarrera(Connection connection, int idcarrera) {
        String result;
        String sql = "DELETE FROM carreras WHERE idcarrera = " + idcarrera;
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            result = "Register deleted";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't delete register";
        }
        return result;

    }
}
