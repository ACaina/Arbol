/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.modelo.funciones;

import accesoDatos.AccesoDatos;
import arbol.modelo.entidades.Problema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Jackeline
 */
public class FProblema {
    public static Problema obtenerProbelmaDadoCodigo(int codigo) throws Exception {
        Problema problema = null;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from arbol.f_buscar_problema_dado_id(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                problema = new Problema();
                problema.setDescripcion(resultSet.getString("descripcion"));
                problema.setFk_causa(FCausa.obtenerCausaDadoCodigo(resultSet.getInt("fk_causa")));
                problema.setFk_involucrado(FInvolucrado.obtenerInvolucradoDadoCodigo(resultSet.getInt("fk_involucrado")));
                //                causa.setId_causa_rec(obtenerCausaDadoCodigo(resultSet.getInt("id_causa_rec")));
//                causa.setSubActividad(FSubActividad.obtenerSubActividadDadoCodigo(resultSet.getInt("id_sub_actividad")));
            }
            accesoDatos.desconectar();
        } catch (Exception e) {
            throw e;
        }
        return problema;
    }
    
    public static ArrayList<Problema> obtenerProblema() throws Exception {
        ArrayList<Problema> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Problema problema;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from arbol.f_seleccionar_problema()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                problema = new Problema();
                problema.setId_problema(resultSet.getInt("id_problema"));
                problema.setDescripcion(resultSet.getString("descripcion"));
                problema.setFk_causa(FCausa.obtenerCausaDadoCodigo(resultSet.getInt("fk_causa")));
                problema.setFk_involucrado(FInvolucrado.obtenerInvolucradoDadoCodigo(resultSet.getInt("fk_involucrado")));
                lst.add(problema);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
    public static String insertarProblema(Problema problema) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_insertar_puesto(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, problema.getDescripcion());
            prstm.setInt(2, problema.getFk_causa().getId_causa());          
            prstm.setInt(3, problema.getFk_involucrado().getId_involucrado());
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
    public static String actualizarProblema(Problema problema) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_actualizar_problema(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, problema.getDescripcion());
            prstm.setInt(2, problema.getFk_causa().getId_causa());
            prstm.setInt(3, problema.getFk_involucrado().getId_involucrado());
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
     public static String eliminarProblema(Problema problema) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_problema(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, problema.getId_problema());
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
