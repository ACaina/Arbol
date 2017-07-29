
package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.Comerciante;

/**
 *
 * @author caina
 */
public class FComerciante {
        public static ArrayList<Comerciante> obtenerSecciones() throws Exception {
        ArrayList<Comerciante> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Comerciante comerciante;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from f_seleccionar_comerciante()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                comerciante = new Comerciante();
                comerciante.setId_comerciante(resultSet.getInt("id_comerciante"));
                comerciante.setTipo_identificador(resultSet.getString("tipo_identificador"));
                seccion.setIdSeccion(resultSet.getInt("id_seccion"));
                seccion.setNombre_seccion(resultSet.getString("nombre_seccion"));
                seccion.setEstado(resultSet.getString("estado"));
                seccion.setArea(resultSet.getDouble("area"));
                seccion.setDimension(resultSet.getString("dimension"));
                lst.add(seccion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}
