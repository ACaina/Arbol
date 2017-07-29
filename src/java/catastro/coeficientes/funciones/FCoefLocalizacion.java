package catastro.coeficientes.funciones;

import accesoDatos.AccesoDatos;
import catastro.coeficientes.entidades.CoefLocalizacion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FCoefLocalizacion {

    public static List<CoefLocalizacion> obtenerCoeficientes() throws Exception {
        List<CoefLocalizacion> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        CoefLocalizacion coeficiente;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * from catastro.f_coefiencientes_localizacion();";
            resultSet = accesoDatos.ejecutaQuery(sql);
            while (resultSet.next()) {
                coeficiente = new CoefLocalizacion();
                coeficiente.setIdCoeficiente(resultSet.getInt("sr_id_coeficiente"));
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
