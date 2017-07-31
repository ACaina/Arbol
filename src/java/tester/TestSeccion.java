/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.ArrayList;
import mercado.modelo.entidades.Puesto;
import mercado.modelo.entidades.Seccion;
import mercado.modelo.entidades.Tarifa;
import mercado.modelo.funciones.FPuesto;
import mercado.modelo.funciones.FSeccion;
import mercado.modelo.funciones.FTarifa;

/**
 *
 * @author caina
 */
public class TestSeccion {
    public static void main(String[] args) throws Exception {
       ArrayList<Tarifa> lst = FTarifa.obtenerTarifas();
        try {
            System.out.println("EntraFor");
            System.out.println(lst.size());
            for(int i=0;i<lst.size();i++){
                
                System.out.println("\n\nId: "+lst.get(i).getIdTarifa()
                +"\n num: "+lst.get(i).getValor_tarifa()
                +"\n Tarifa "+lst.get(i).getIdSeccion().getNombre_seccion()
                +"\n Mercado "+lst.get(i).getId_tipo_puesto().getDescripcion_tipo_puesto()
                );
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
