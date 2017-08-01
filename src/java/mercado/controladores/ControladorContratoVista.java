/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mercado.modelo.entidades.Actividad;
import mercado.modelo.entidades.Comerciante;
import mercado.modelo.entidades.Contrato;
import mercado.modelo.entidades.Puesto;
import mercado.modelo.funciones.FActividad;
import mercado.modelo.funciones.FComerciante;
import mercado.modelo.funciones.FContrato;
import mercado.modelo.funciones.FPuesto;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorContratoVista {
    private ArrayList<Contrato> lstContrato;
    private ArrayList<Comerciante> lstComerciante;
    private ArrayList<Puesto> lstPuesto;
    private ArrayList<Actividad> lstActividad; 
//    private Puesto objPuesto;
    private Contrato contratoSel;
    private String identificador;
//    private String msgBD;

    public ControladorContratoVista() {
            contratoSel = new Contrato();
        obtenerContrato();
        obtenerComerciante();
        obtenerPuesto();
        obtenerActividad();
    }

    public void obtenerContrato() {
        try {
            lstContrato = FContrato.obtenerContrato();
        } catch (Exception e) {
            System.out.println("public void obtenerContrato() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerComerciante() {
        try {
            lstComerciante = FComerciante.obtenerComerciantes();
        } catch (Exception e) {
            System.out.println("public void obtenerComerciante() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerPuesto() {
        try {
            lstPuesto = FPuesto.obtenerPuestos();
        } catch (Exception e) {
            System.out.println("public void obtenerPuesto() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }
    
    public void obtenerActividad() {
        try {
            lstActividad = FActividad.obtenerActividades();
        } catch (Exception e) {
            System.out.println("public void obtenerActividad() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public ArrayList<Contrato> getLstContrato() {
        return lstContrato;
    }

    public void setLstContrato(ArrayList<Contrato> lstContrato) {
        this.lstContrato = lstContrato;
    }

    public ArrayList<Comerciante> getLstComerciante() {
        return lstComerciante;
    }

    public void setLstComerciante(ArrayList<Comerciante> lstComerciante) {
        this.lstComerciante = lstComerciante;
    }

    public ArrayList<Puesto> getLstPuesto() {
        return lstPuesto;
    }

    public void setLstPuesto(ArrayList<Puesto> lstPuesto) {
        this.lstPuesto = lstPuesto;
    }

    public ArrayList<Actividad> getLstActividad() {
        return lstActividad;
    }

    public void setLstActividad(ArrayList<Actividad> lstActividad) {
        this.lstActividad = lstActividad;
    }

    public Contrato getContratoSel() {
        return contratoSel;
    }

    public void setContratoSel(Contrato contratoSel) {
        this.contratoSel = contratoSel;
    }


   
}
