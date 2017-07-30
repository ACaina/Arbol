/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.ArrayList;
import mercado.modelo.entidades.Tpuesto;
import mercado.modelo.funciones.FTipoPuesto;

/**
 *
 * @author ♥ Erika
 */

public class TestTPuesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            Tpuesto tpuesto = FTipoPuesto.obtenerTpuestoDadoCodigo(1);
            System.out.println("\n Sub actividad: " + tpuesto.getDescripcion_tipo_puesto()
                    + "\n Id: " + tpuesto.getId_tipo_puesto());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        
         ArrayList<Tpuesto> lst = FTipoPuesto.obtenerTpuestos();
        try {
            for(int i=0;i<lst.size();i++){
                System.out.println("\n\nTipo Puesto: "+lst.get(i).getDescripcion_tipo_puesto()
                +"\n id: "+lst.get(i).getId_tipo_puesto());
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

    }
}
