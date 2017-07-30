package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.SubActividad;

public class FSubActividad {

    public static SubActividad obtenerSubActividadDadoCodigo(int codigo) throws Exception {
        SubActividad subActividad = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * FROM f_seleccionar_sub_actividad_dado_id(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                subActividad = new SubActividad();
                subActividad.setIdSubActividad(resultSet.getInt("id_sub_actividad"));
                subActividad.setSubActividad(resultSet.getString("descripcion_sub_actividad"));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return subActividad;
    }

    public static ArrayList<SubActividad> obtenerSubActividades() throws Exception {
        ArrayList<SubActividad> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        SubActividad subActividad;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from public.f_seleccionar_sub_actividad()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                subActividad = new SubActividad();
                subActividad.setIdSubActividad(resultSet.getInt("id_sub_actividad"));
                subActividad.setSubActividad(resultSet.getString("descripcion_sub_actividad"));
                lst.add(subActividad);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
    
        public static String insertarSubActividad(SubActividad subactividad) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_sub_actividad(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, subactividad.getSubActividad());
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
    
     public static String actualizarSubActividad(SubActividad subactividad) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_sub_actividad(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, subactividad.getIdSubActividad());
            prstm.setString(2, subactividad.getSubActividad());
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
    
        public static String eliminarSubActividad(SubActividad subactividad) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_sub_actividad(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, subactividad.getIdSubActividad());
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
