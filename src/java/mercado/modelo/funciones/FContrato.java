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
import mercado.modelo.entidades.Contrato;

/**
 *
 * @author caina
 */
public class FContrato {

    public static Contrato obtenerContratoDadoIdContrato (int codigo) throws Exception {
        Contrato contrato = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_seleccionar_contrato_dado_id(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                contrato = new Contrato();
                contrato.setId_contrato(resultSet.getInt("id_contrato"));
                contrato.setFecha_inicio(resultSet.getString("fecha_inicio"));
                contrato.setFecha_fin(resultSet.getString("fecha_fin"));
                contrato.setId_comerciante(FComerciante.obtenerComercianteDadoId(resultSet.getInt("id_comerciante")));
                contrato.setId_puesto(FPuesto.obtenerPuestoDadoCodigo(resultSet.getInt("id_puesto")));
                contrato.setIdActividad(FActividad.obtenerActividadDadoCodigo(resultSet.getInt("idActividad")));   
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return contrato;
    }

    public static ArrayList<Contrato> obtenerContrato() throws Exception {
        ArrayList<Contrato> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Contrato contrato;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from f_seleccionar_contrato()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                contrato = new Contrato();
                contrato.setId_contrato(resultSet.getInt("id_contrato"));
                contrato.setFecha_inicio(resultSet.getString("fecha_inicio"));
                contrato.setFecha_fin(resultSet.getString("fecha_fin"));
                contrato.setId_comerciante(FComerciante.obtenerComercianteDadoId(resultSet.getInt("id_comerciante")));
                contrato.setId_puesto(FPuesto.obtenerPuestoDadoCodigo(resultSet.getInt("id_puesto")));
                contrato.setIdActividad(FActividad.obtenerActividadDadoCodigo(resultSet.getInt("id_actividad")));   
                lst.add(contrato);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String insertarContrato(Contrato contrato) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_contrato(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, contrato.getFecha_inicio());
            prstm.setString(2, contrato.getFecha_fin());
            prstm.setString(3, contrato.getId_comerciante().getIdentificador());
            prstm.setInt(4, contrato.getId_comerciante().getId_comerciante());
            prstm.setInt(5, contrato.getIdActividad().getIdActividad());
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

    public static String actualizarContrato(Contrato contrato) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_contrato(?,?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, contrato.getId_contrato());
            prstm.setString(2, contrato.getFecha_inicio());
            prstm.setString(3, contrato.getFecha_fin());
            prstm.setInt(4, contrato.getId_comerciante().getId_comerciante());
            prstm.setInt(5, contrato.getId_puesto().getId_puesto());
            prstm.setInt(6, contrato.getIdActividad().getIdActividad());
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

    public static String eliminarContrato(Contrato contrato) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_contrato(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, contrato.getId_contrato());
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
