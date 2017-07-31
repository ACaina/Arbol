/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import mercado.modelo.entidades.Seccion;
import mercado.modelo.entidades.SubActividad;
import mercado.modelo.entidades.Tpuesto;
import mercado.modelo.funciones.FSeccion;
import mercado.modelo.funciones.FSubActividad;
import mercado.modelo.funciones.FTipoPuesto;

/**
 *
 * @author Geovanny
 */
public class TestSubActividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
           // SubActividad sub = FSubActividad.obtenerSubActividadDadoCodigo(1);
            Tpuesto sub = FTipoPuesto.obtenerTpuestoDadoCodigo(1);
            //Seccion sub =FSeccion.obtenerSeccionDadoCodigo(2);
            System.out.println("\n Sub actividad: " + sub.getDescripcion_tipo_puesto()
                    );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
