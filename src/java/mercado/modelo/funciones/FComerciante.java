package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.Comerciante;

/**
 *
 * @author ♥ Erika
 */
public class FComerciante {

    public static ArrayList<Comerciante> obtenerComerciantes() throws Exception {
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
                comerciante.setIdentificador(resultSet.getString("identificador"));
                comerciante.setNombres_c(resultSet.getString("nombres_c"));
                comerciante.setApellidos_c(resultSet.getString("apellidos_c"));
                comerciante.setDireccion_c(resultSet.getString("direccion_c"));
                comerciante.setCorreo_c(resultSet.getString("correo_c"));
                comerciante.setConadis(resultSet.getString("conadis"));
                comerciante.setTelefono(resultSet.getString("telefono"));
                lst.add(comerciante);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static Comerciante obtenerComercianteDadoIentificador(String ident) throws Exception {
        Comerciante comerciante = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * FROM f_seleccionar_comerciante_dado_identificador(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, ident);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                comerciante = new Comerciante();
                comerciante.setId_comerciante(resultSet.getInt("id_comerciante"));
                comerciante.setTipo_identificador(resultSet.getString("tipo_identificador"));
                comerciante.setIdentificador(resultSet.getString("identificador"));
                comerciante.setNombres_c(resultSet.getString("nombres_c"));
                comerciante.setApellidos_c(resultSet.getString("apellidos_c"));
                comerciante.setDireccion_c(resultSet.getString("direccion_c"));
                comerciante.setCorreo_c(resultSet.getString("correo_c"));
                comerciante.setConadis(resultSet.getString("conadis"));
                comerciante.setTelefono(resultSet.getString("telefono"));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return comerciante;
    }

    public static String insertarComerciante(Comerciante comerciante) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_comerciante(?,?,?,?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, comerciante.getTipo_identificador());
            prstm.setString(2, comerciante.getIdentificador());
            prstm.setString(3, comerciante.getNombres_c());
            prstm.setString(4, comerciante.getApellidos_c());
            prstm.setString(5, comerciante.getDireccion_c());
            prstm.setString(6, comerciante.getCorreo_c());
            prstm.setString(7, comerciante.getConadis());
            prstm.setString(8, comerciante.getTelefono());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String actualizarComerciante(Comerciante comerciante) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_comerciante((?,?,?,?,?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, comerciante.getId_comerciante());
            prstm.setString(2, comerciante.getTipo_identificador());
            prstm.setString(3, comerciante.getIdentificador());
            prstm.setString(4, comerciante.getNombres_c());
            prstm.setString(5, comerciante.getApellidos_c());
            prstm.setString(6, comerciante.getDireccion_c());
            prstm.setString(7, comerciante.getCorreo_c());
            prstm.setString(8, comerciante.getConadis());
            prstm.setString(9, comerciante.getTelefono());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String eliminarComerciante(Comerciante comerciante) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_comerciante(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, comerciante.getId_comerciante());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                res = resultSet.getString(1);
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
