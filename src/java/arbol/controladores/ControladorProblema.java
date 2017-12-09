/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.controladores;

import arbol.modelo.entidades.Causa;
import arbol.modelo.entidades.Involucrado;
import arbol.modelo.entidades.Problema;
import arbol.modelo.funciones.FCausa;
import static arbol.modelo.funciones.FCausa.obtenerCausas;
import arbol.modelo.funciones.FInvolucrado;
import static arbol.modelo.funciones.FInvolucrado.obtenerInvolucrado;
import arbol.modelo.funciones.FProblema;
import static arbol.modelo.funciones.FProblema.obtenerProblema;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author Jackeline
 */
public class ControladorProblema implements Serializable{
    private ArrayList<Problema> lstProblema;
    private ArrayList<Causa> lstCausa;
    private ArrayList<Involucrado> lstInvolucrado;
    private Problema objProblema;
    private Problema problemaSel;
    private String msgBD;

    public ControladorProblema() {
        objProblema = new Problema();
        problemaSel = new Problema();
        obtenerProblema();
        obtenerCausas();
        obtenerInvolucrado();
    }
    

    public void obtenerProblema() {
        try {
            lstProblema = FProblema.obtenerProblema();
            System.out.println("total de Problemas: " + lstProblema.size());
        } catch (Exception e) {
//            System.out.println("public void obtenerActividades() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerCausas() {
        try {
            lstCausa = FCausa.obtenerCausas();
            System.out.println("total de CAUSAS: "+lstCausa.size());
        } catch (Exception e) {
            System.out.println("public void obtenerCausas() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerInvolucrado() {
        try {
            lstInvolucrado = FInvolucrado.obtenerInvolucrado();
            System.out.println("total de INVOLUCRADOS: "+lstInvolucrado.size());
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FProblema.insertarProblema(objProblema);
            objProblema = new Problema();
            obtenerProblema();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblProblema");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarProblema').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FProblema.actualizarProblema(problemaSel);
            problemaSel = new Problema();
            obtenerProblema();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblProblema");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarProblema').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FProblema.eliminarProblema(problemaSel);
            problemaSel = new Problema();
            obtenerProblema();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblProblema");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarProblema').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Problema> getLstProblema() {
        return lstProblema;
    }

    public void setLstProblema(ArrayList<Problema> lstPuesto) {
        this.lstProblema = lstProblema;
    }

    public ArrayList<Causa> getLstCausa() {
        return lstCausa;
    }
    
    public void setLstCausa(ArrayList<Causa> lstCausa) {
        this.lstCausa = lstCausa;
    }

    public ArrayList<Involucrado> getLstInvoludrado() {
        return lstInvolucrado;
    }

    public void setLstInvolucrado(ArrayList<Involucrado> lstInvolucrado) {
        this.lstInvolucrado = lstInvolucrado;
    }
    public Problema getObjPuesto() {
        return objProblema;
    }

    public void setObjPuesto(Problema objPuesto) {
        this.objProblema = objPuesto;
    }

    public Problema getPuestoSel() {
        return problemaSel;
    }

    public void setPuestoSel(Problema puestoSel) {
        this.problemaSel = puestoSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }


    
}
