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
import mercado.modelo.entidades.Actividad;
import mercado.modelo.entidades.Puesto;

/**
 *
 * @author caina
 */
public class FPuesto {
 
     public static Puesto obtenerPuestoDadoCodigo(int codigo) throws Exception {
        Puesto puesto = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_seleccionar_puesto_dado_id(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                puesto = new Puesto();
                puesto.setId_puesto(resultSet.getInt("id_puesto"));
                puesto.setNumero_puesto(resultSet.getString("numero_puesto"));
                puesto.setId_tarifa(null);
                puesto.setId_mercado(FMercado.obtenerMercadoDadoCodigo(resultSet.getInt("id_mercado")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return puesto;
    }
    
    
        public static ArrayList<Puesto> obtenerPuestos() throws Exception {
        ArrayList<Puesto> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Puesto puesto;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select* from f_seleccionar_puesto()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                puesto = new Puesto();
                puesto.setId_puesto(resultSet.getInt("id_puesto"));
                puesto.setNumero_puesto(resultSet.getString("numero_puesto"));
                puesto.setId_tarifa(null);
                puesto.setId_mercado(FMercado.obtenerMercadoDadoCodigo(resultSet.getInt("id_mercado")));
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
        
        public static String insertarPuesto(Puesto puesto) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_puesto(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, puesto.getNumero_puesto());
            prstm.setInt(2, puesto.getId_tarifa().getIdTarifa());
            prstm.setInt(3, puesto.getId_mercado().getId_mercado());
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
        
    public static String actualizarPuesto(Puesto puesto) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_puesto(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, puesto.getNumero_puesto());
            prstm.setInt(2, puesto.getId_tarifa().getIdTarifa());
            prstm.setInt(3, puesto.getId_mercado().getId_mercado());
            prstm.setInt(4,puesto.getId_puesto());
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
    
     public static String eliminarPuesto(Puesto puesto) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_puesto(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, puesto.getId_puesto());
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
