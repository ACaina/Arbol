/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controladores;

import java.util.ArrayList;
import mercado.modelo.entidades.Seccion;
import mercado.modelo.funciones.FSeccion;
import recursos.Util;

/**
 *
 * @author caina
 */
public class ControladorSeccion {
    
     public ControladorSeccion() {
    }
    
    private ArrayList<Seccion> lstSecciones;
    
        public void obtenerActividades() {
        try {
            lstSecciones = FSeccion.obtenerSecciones();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public ArrayList<Seccion> getLstSecciones() {
        return lstSecciones;
    }

    public void setLstSecciones(ArrayList<Seccion> lstSecciones) {
        this.lstSecciones = lstSecciones;
    }

   
        
        
        
}
