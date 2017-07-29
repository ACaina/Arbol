package catastro.coeficientes.funciones;

import accesoDatos.AccesoDatos;
import catastro.coeficientes.entidades.CoefVentanas;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FCoefAcabVentanas {

    public static List<CoefVentanas> obtenerCoeficientes() throws Exception {
        List<CoefVentanas> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        CoefVentanas coeficiente;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * from catastro.f_coefiencientes_ventanas();";
            resultSet = accesoDatos.ejecutaQuery(sql);
            while (resultSet.next()) {
                coeficiente = new CoefVentanas();
                coeficiente.setIdCoefVentanas(resultSet.getInt("sr_id_coef_ventana"));
                coeficiente.setCoeficiente(resultSet.getString("chv_coeficiente"));
                coeficiente.setCodigo(resultSet.getInt("int_codigo"));
                coeficiente.setValorCoeficiente(resultSet.getDouble("db_valor_coef"));
                coeficiente.setEstadoLogico(resultSet.getString("ch_estado_logico"));
                coeficiente.setFechaRegistro(resultSet.getTimestamp("ts_fecha_registro"));
                coeficiente.setFechaActualizacion(resultSet.getTimestamp("ts_fecha_actualizacion"));
                coeficiente.setFechaBaja(resultSet.getTimestamp("ts_fecha_baja"));
                lst.add(coeficiente);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}
