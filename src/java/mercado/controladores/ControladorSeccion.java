/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mercado.modelo.entidades.Seccion;
import mercado.modelo.funciones.FSeccion;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorSeccion {
    
    private ArrayList<Seccion> lstSecciones;
    private Seccion seccionSel;
    private String estado;
    private int id;
    
    public ControladorSeccion() {
        seccionSel = new Seccion();
        obtenerSecciones();
    }
    
    public void obtenerSecciones() {
        try {
            lstSecciones = FSeccion.obtenerSecciones();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    
    public void obtenerSeccionesDadoEstado() {
        try {
            lstSecciones = FSeccion.obtenerSeccionesDadoEstado(estado);
        } catch (Exception e) {
            System.out.println("public void obtenerSeccionesDadoEstado() dice: " + e.getMessage());
            Util.addErrorMessage("public void obtenerSeccionesDadoEstado() dice: " + e.getMessage());
        }
    }
    
    public Seccion getSeccionSel() {
        return seccionSel;
    }
    
    public void setSeccionSel(Seccion seccionSel) {
        this.seccionSel = seccionSel;
    }
    
    public ArrayList<Seccion> getLstSecciones() {
        return lstSecciones;
    }
    
    public void setLstSecciones(ArrayList<Seccion> lstSecciones) {
        this.lstSecciones = lstSecciones;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
