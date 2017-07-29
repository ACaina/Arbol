/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.ArrayList;
import mercado.modelo.entidades.Seccion;
import mercado.modelo.funciones.FSeccion;

/**
 *
 * @author caina
 */
public class TestSeccion {
    public static void main(String[] args) throws Exception {
       ArrayList<Seccion> lst = FSeccion.obtenerSecciones();
        try {
            for(int i=0;i<lst.size();i++){
                System.out.println("\n\nId: "+lst.get(i).getIdSeccion()
                +"\n Nombre: "+lst.get(i).getNombre_seccion()
                +"\n Estado "+lst.get(i).getEstado()
                +"\n Area "+lst.get(i).getArea()
                +"\n Area "+lst.get(i).getDimension()
                );
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
