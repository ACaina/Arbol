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
            consulta = "select * from f_seleccionar_tarifa()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                tarifa = new Tarifa();
                tarifa.setIdTarifa(resultSet.getInt("id_tarifa"));
                tarifa.setValor_tarifa(resultSet.getDouble("valor_tarifa"));
                tarifa.setIdSeccion(FSeccion.obtenerSeccionDadoCodigo(resultSet.getInt("id_seccion")));
                tarifa.setId_tipo_puesto(FTipoPuesto.obtenerTpuestoDadoCodigo(resultSet.getInt("id_tipo_puesto")));
                lst.add(tarifa);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String insertarTarifa(Tarifa tarifa) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_tarifa(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setDouble(1, tarifa.getValor_tarifa());
            prstm.setInt(2, tarifa.getIdSeccion().getIdSeccion());
            //prstm.setString(2, tarifa.getIdSeccion().getNombre_seccion());
            //prstm.setInt(3,tarifa.getId_tipo_puesto().getDescripcion_tipo_puesto());
            prstm.setInt(3, tarifa.getId_tipo_puesto().getId_tipo_puesto());
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

    public static Tarifa obtenerTarifaDadoId(int id) throws Exception {
        Tarifa tarifa=null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_seleccionar_tarifa_dado_id(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, id);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                tarifa = new Tarifa();
                tarifa.setIdTarifa(resultSet.getInt("id_tarifa"));
                tarifa.setValor_tarifa(resultSet.getDouble("valor_tarifa"));
                tarifa.setIdSeccion(FSeccion.obtenerSeccionDadoCodigo(resultSet.getInt("id_seccion")));
                tarifa.setId_tipo_puesto(FTipoPuesto.obtenerTpuestoDadoCodigo(resultSet.getInt("id_tipo_puesto")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return tarifa;
    }

    public static String actualizarTarifa(Tarifa tarifa) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_tarifa((?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, tarifa.getIdTarifa());
            prstm.setDouble(2, tarifa.getValor_tarifa());
            prstm.setInt(3, tarifa.getIdSeccion().getIdSeccion());
            //prstm.setString(2, tarifa.getIdSeccion().getNombre_seccion());
            //prstm.setInt(3,tarifa.getId_tipo_puesto().getDescripcion_tipo_puesto());
            prstm.setInt(4, tarifa.getId_tipo_puesto().getId_tipo_puesto());
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

    public static String eliminarTarifa(Tarifa tarifa) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_tarifa(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, tarifa.getIdTarifa());
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
