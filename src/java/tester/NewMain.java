/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import mercado.modelo.entidades.Actividad;
import mercado.modelo.funciones.FActividad;
import mercado.modelo.funciones.FComprobante;

/**
 *
 * @author Morita
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Total de comprobantes: "
                    + FComprobante.obtenerComprobantes().size());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
