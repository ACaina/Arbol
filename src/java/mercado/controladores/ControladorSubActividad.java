/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mercado.modelo.entidades.SubActividad;
import mercado.modelo.funciones.FSubActividad;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorSubActividad implements Serializable{
    
    private ArrayList<SubActividad> lstSubactividad;
    private SubActividad subactividadSel;
    private SubActividad objSubactividad;
    //private int id;
    private String msgBD;

    public ControladorSubActividad() {
        objSubactividad = new SubActividad();
        subactividadSel = new SubActividad();
        obtenerSubactividad();
    }

    public void obtenerSubactividad() {
        try {
            lstSubactividad = FSubActividad.obtenerSubActividades();
            System.out.println("Muestra secciones ");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            System.out.println("Ingresa insertar ");
            msgBD = FSubActividad.insertarSubActividad(objSubactividad);
            objSubactividad = new SubActividad();
            obtenerSubactividad();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblSubactividad");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarSubactividad').hide()");
        } catch (Exception e) {

            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FSubActividad.actualizarSubActividad(subactividadSel);
            subactividadSel = new SubActividad();
            obtenerSubactividad();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblSubactividad");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarSubactividad').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FSubActividad.eliminarSubActividad(subactividadSel);
            subactividadSel = new SubActividad();
            obtenerSubactividad();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblSubactividad");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarSubactividad').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<SubActividad> getLstSubactividad() {
        return lstSubactividad;
    }

    public void setLstSubactividad(ArrayList<SubActividad> lstSubactividad) {
        this.lstSubactividad = lstSubactividad;
    }

    public SubActividad getSubactividadSel() {
        return subactividadSel;
    }

    public void setSubactividadSel(SubActividad subactividadSel) {
        this.subactividadSel = subactividadSel;
    }

    public SubActividad getObjSubactividad() {
        return objSubactividad;
    }

    public void setObjSubactividad(SubActividad objSubactividad) {
        this.objSubactividad = objSubactividad;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
    
    
    
}
