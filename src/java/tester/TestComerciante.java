/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import java.util.ArrayList;
import mercado.modelo.entidades.Comerciante;
import mercado.modelo.funciones.FComerciante;

/**
 *
 * @author ♥ Erika
 */
public class TestComerciante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            Comerciante comerciante = FComerciante.obtenerComercianteDadoId(1);
            System.out.println("\n\nId_comerciante: " + comerciante.getId_comerciante()
                    + "\n tipo_identificador: " + comerciante.getTipo_identificador()
                    + "\n identificador: " + comerciante.getIdentificador()
                    + "\n nombres_c: " + comerciante.getNombres_c()
                    + "\n apellidos_c: " + comerciante.getApellidos_c()
                    + "\n direccion_c: " + comerciante.getDireccion_c()
                    + "\n correo_c: " + comerciante.getCorreo_c()
                    + "\n conadis: " + comerciante.getConadis()
                    + "\n telefono: " + comerciante.getTelefono()
            );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<Comerciante> lst = FComerciante.obtenerComerciantes();
        try {
            for (int i = 0; i < lst.size(); i++) {
                System.out.println("\n\nId_comerciante: " + lst.get(i).getId_comerciante()
                        + "\n tipo_identificador: " + lst.get(i).getTipo_identificador()
                        + "\n identificador: " + lst.get(i).getIdentificador()
                        + "\n nombres_c: " + lst.get(i).getNombres_c()
                        + "\n apellidos_c: " + lst.get(i).getApellidos_c()
                        + "\n direccion_c: " + lst.get(i).getDireccion_c()
                        + "\n correo_c: " + lst.get(i).getCorreo_c()
                        + "\n conadis: " + lst.get(i).getConadis()
                        + "\n telefono: " + lst.get(i).getTelefono()
                );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
