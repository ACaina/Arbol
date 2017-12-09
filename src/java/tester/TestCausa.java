/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import arbol.modelo.entidades.Causa;
import arbol.modelo.funciones.FCausa;
import java.util.ArrayList;

/**
 *
 * @author caina
 */
public class TestCausa {
     public static void main(String[] args) throws Exception {
        try {
            Causa comerciante = FCausa.obtenerCausaDadoCodigo(1);
            System.out.println("\n\nId_causa: " + comerciante.getId_causa()
                    + "\n nombre_causa: " + comerciante.getNombre_causa()
                    + "\n titulo: " + comerciante.getTitulo()
                    + "\n : " + comerciante.getId_causa_rec()
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<Causa> lst = FCausa.obtenerCausas();
        try {
            for (int i = 0; i < lst.size(); i++) {
                System.out.println("\n\nId_causa: " + lst.get(i).getId_causa()
                        + "\n nombre_causa: " + lst.get(i).getNombre_causa()
                        + "\n titulo: " + lst.get(i).getTitulo()
                        + "\n id_causa_rec: " + lst.get(i).getId_causa_rec()
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
