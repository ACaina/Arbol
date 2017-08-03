package mercado.modelo.funciones;

import accesoDatos.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mercado.modelo.entidades.Comprobante;

public class FComprobante {

    public static ArrayList<Comprobante> obtenerComprobantes() throws Exception {
        ArrayList<Comprobante> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        Comprobante comprobante;
        ResultSet resultSet;
        String consulta;
        try {
            accesoDatos = new AccesoDatos();
            consulta = "select * from f_seleccionar_comprobante()";
            resultSet = accesoDatos.ejecutaQuery(consulta);
            while (resultSet.next()) {
                comprobante = new Comprobante();
                comprobante.setId_tarifa(FTarifa.obtenerTarifaDadoId(resultSet.getInt("id_tarifa")));
                comprobante.setIva(resultSet.getDouble("iva"));
                comprobante.setId_contrato(FContrato.obtenerContratoDadoIdContrato(resultSet.getInt("id_contrato")));
                comprobante.setMes_pago(resultSet.getDate("mes_pago"));
                comprobante.setId_comprobante(resultSet.getInt("id_comprobante"));
                comprobante.setFecha_emision(resultSet.getTimestamp("fecha_emision"));
                comprobante.setAño_pago(resultSet.getDate("año_pago"));
                lst.add(comprobante);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String eliminarComprobante(Comprobante comprobante) throws Exception {
        String res;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from f_eliminar_comprobante(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, comprobante.getId_comprobante());
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
