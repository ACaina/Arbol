/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.Mercado;

/**
 *
 * @author caina
 */
public class FMercado {

    public static ArrayList<Mercado> obtenerMercados() throws Exception {
        ArrayList<Mercado> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Mercado mercado;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from f_seleccionar_mercado()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                mercado = new Mercado();
                mercado.setId_mercado(resultSet.getInt("id_mercado"));
                mercado.setNombre_mercado(resultSet.getString("nombre_mercado"));
                mercado.setEstado(resultSet.getString("estado"));
                lst.add(mercado);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String insertarMercado(Mercado mercado) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_mercado(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, mercado.getNombre_mercado());
            prstm.setString(2, mercado.getEstado());
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

    public static String actualizarMercado(Mercado mercado) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_mercado(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, mercado.getNombre_mercado());
            prstm.setString(2, mercado.getEstado());
            prstm.setInt(3, mercado.getId_mercado());
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

    public static String eliminarMercado(Mercado mercado) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_mercado(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, mercado.getId_mercado());
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
