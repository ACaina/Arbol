package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.Actividad;

public class FActividad {

    public static ArrayList<Actividad> obtenerActividades() throws Exception {
        ArrayList<Actividad> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Actividad actividad;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from public.f_seleccionar_actividad()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                actividad = new Actividad();
                actividad.setIdActividad(resultSet.getInt("id_actividad"));
                actividad.setDescripcion(resultSet.getString("descripcion_actividad"));
                actividad.setSubActividad(FSubActividad.obtenerSubActividadDadoCodigo(resultSet.getInt("id_sub_actividad")));
                lst.add(actividad);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String insertarActividad(Actividad actividad) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_actividad(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, actividad.getDescripcion());
            prstm.setInt(2, actividad.getSubActividad().getIdSubActividad());
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

    public static String actualizarActividad(Actividad actividad) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_actividad(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, actividad.getDescripcion());
            prstm.setInt(2, actividad.getSubActividad().getIdSubActividad());
            prstm.setInt(3, actividad.getIdActividad());
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

    public static String eliminarActividad(Actividad actividad) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_actividad(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, actividad.getIdActividad());
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
