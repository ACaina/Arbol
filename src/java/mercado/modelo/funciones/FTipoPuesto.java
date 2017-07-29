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
import mercado.modelo.entidades.Tpuesto;

/**
 *
 * @author ♥ Erika
 */
public class FTipoPuesto {
    
    public static Tpuesto obtenerTpuestoDadoCodigo(int codigo) throws Exception {
        Tpuesto tpuesto = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * FROM f_seleccionar_tipo_puesto_dado_id(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                tpuesto = new Tpuesto();
                tpuesto.setId_tipo_puesto(resultSet.getInt("id_tipo_puesto"));
                tpuesto.setDescripcion_tipo_puesto(resultSet.getString("descripcion_tipo_puesto"));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return tpuesto;
    }
    
    public static ArrayList<Tpuesto> obtenerTpuesto() throws Exception {
        ArrayList<Tpuesto> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Tpuesto tpuesto;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from public.f_seleccionar_tipo_puesto()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                tpuesto = new Tpuesto();
                tpuesto.setId_tipo_puesto(resultSet.getInt("id_tipo_puesto"));
                tpuesto.setDescripcion_tipo_puesto(resultSet.getString("descripcion_tipo_puesto"));
                lst.add(tpuesto);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
   
    
    public static String insertarTipopuesto(Tpuesto tpuesto) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_tipo_puesto(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, tpuesto.getDescripcion_tipo_puesto());
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
    
    public static String actualizarTpuesto(Tpuesto tpuesto) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_tipo_puesto(?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, tpuesto.getId_tipo_puesto());
            prstm.setString(2, tpuesto.getDescripcion_tipo_puesto());
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

    public static String eliminarTpuesto(Tpuesto tpuesto) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * f_eliminar_tipo_puesto(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, tpuesto.getId_tipo_puesto());
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
