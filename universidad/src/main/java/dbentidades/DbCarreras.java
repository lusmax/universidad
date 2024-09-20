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
    //CREAR CONEXION A LA BASE DE DATOS
    private static final Connection CONNECTION = DbConnection.getConnection();

    //Métodos
    //SELECT
    public static Carrera getCarrera(String carrera) {
        Carrera miCarrera = new Carrera();
        ResultSet result;
        String sql = "SELECT * FROM carreras "
                + "WHERE carrera LIKE '" + carrera + "'";

        try {
            Statement st = DbCarreras.CONNECTION.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                miCarrera.setIdcarrera(result.getInt("idcarrera"));
                miCarrera.setCarrera(result.getString("carrera"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return miCarrera;
    }

    //INSERT
    public static String insertCarrera(Carrera miCarrera) {
        String result;
        String sql = "INSERT INTO carreras (carrera)"
                + " VALUES ('" + miCarrera.getCarrera() + "')";
        try {
            Statement st = DbCarreras.CONNECTION.createStatement();
            st.executeUpdate(sql);
            result = "New register inserted";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't insert register";
        }
        return result;
    }

    //UPDATE
    public static String updateCarrera(String updateCarrera, Carrera miCarrera) {
        String result;
        String sql = "UPDATE carreras "
                + "SET carrera = '" + updateCarrera + "'"
                + " WHERE (idcarrera = " + miCarrera.getIdcarrera() + ")";

        try {
            Statement st = DbCarreras.CONNECTION.createStatement();
            st.executeUpdate(sql);
            result = "Register updated";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't update register";
        }
        return result;
    }

    //DELETE 
    public static String deleteCarrera(Carrera miCarrera) {
        String result;
        String sql = "DELETE FROM carreras WHERE idcarrera = " + miCarrera.getIdcarrera();
        try {
            Statement st = DbCarreras.CONNECTION.createStatement();
            st.executeUpdate(sql);
            result = "Register deleted";
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = "Can't delete register";
        }
        return result;

    }
}
