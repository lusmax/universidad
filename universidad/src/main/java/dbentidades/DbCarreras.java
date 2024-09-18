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

}
