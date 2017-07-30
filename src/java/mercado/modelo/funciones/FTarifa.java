/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.Tarifa;

/**
 *
 * @author ♥ Erika
 */
public class FTarifa {

    public static ArrayList<Tarifa> obtenerTarifas() throws Exception {
        ArrayList<Tarifa> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Tarifa tarifa;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from ";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                seccion = new Seccion();
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

    public static String insertarSesion(Seccion seccion) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_seccion(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, seccion.getNombre_seccion());
            prstm.setString(2, seccion.getEstado());
            prstm.setDouble(3, seccion.getArea());
            prstm.setString(4, seccion.getDimension());
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

    public static ArrayList<Seccion> obtenerSeccionesDadoEstado(String estado) throws Exception {
        ArrayList<Seccion> lst = new ArrayList<>();
        Seccion seccion;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_buscar_secciones(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, estado);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                seccion = new Seccion();
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

    public static String actualizarSeccion(Seccion seccion) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_seccion(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, seccion.getIdSeccion());
            prstm.setString(2, seccion.getNombre_seccion());
            prstm.setString(3, seccion.getEstado());
            prstm.setDouble(4, seccion.getArea());
            prstm.setString(5, seccion.getDimension());
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

    public static String eliminarSeccion(Seccion seccion) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_seccion(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, seccion.getIdSeccion());
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
