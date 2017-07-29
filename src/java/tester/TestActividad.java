/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.ArrayList;
import mercado.modelo.entidades.Actividad;
import mercado.modelo.funciones.FActividad;

/**
 *
 * @author Geovanny
 */
public class TestActividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       ArrayList<Actividad> lst = FActividad.obtenerActividades();
        try {
            for(int i=0;i<lst.size();i++){
                System.out.println("\n\nActividad: "+lst.get(i).getDescripcion()
                +"\n id: "+lst.get(i).getIdActividad()
                +"\n subactividad "+lst.get(i).getSubActividad().getSubActividad());
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
