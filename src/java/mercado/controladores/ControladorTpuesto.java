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
import mercado.modelo.entidades.Tpuesto;
import mercado.modelo.funciones.FTipoPuesto;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorTpuesto implements Serializable{

    private ArrayList<Tpuesto> lstTpuesto;
    private Tpuesto tpuestoSel;
    private Tpuesto objTpuesto;
    private int id;
    private String msgBD;

    public ControladorTpuesto() {
        objTpuesto = new Tpuesto();
        tpuestoSel = new Tpuesto();
        obtenerTpuesto();
    }

    public void obtenerTpuesto() {
        try {
            lstTpuesto = FTipoPuesto.obtenerTpuestos();
            System.out.println("Muestra secciones ");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            System.out.println("Ingresa insertar ");
            msgBD = FTipoPuesto.insertarTipopuesto(objTpuesto);
            objTpuesto = new Tpuesto();
            obtenerTpuesto();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblTpuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarTpuesto').hide()");
        } catch (Exception e) {

            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FTipoPuesto.actualizarTpuesto(tpuestoSel);
            tpuestoSel = new Tpuesto();
            obtenerTpuesto();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblTpuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarTpuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FTipoPuesto.eliminarTpuesto(tpuestoSel);
            tpuestoSel = new Tpuesto();
            obtenerTpuesto();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblTpuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarTpuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Tpuesto> getLstTpuesto() {
        return lstTpuesto;
    }

    public void setLstTpuesto(ArrayList<Tpuesto> lstTpuesto) {
        this.lstTpuesto = lstTpuesto;
    }

    public Tpuesto getTpuestoSel() {
        return tpuestoSel;
    }

    public void setTpuestoSel(Tpuesto tpuestoSel) {
        this.tpuestoSel = tpuestoSel;
    }

    public Tpuesto getObjTpuesto() {
        return objTpuesto;
    }

    public void setObjTpuesto(Tpuesto objTpuesto) {
        this.objTpuesto = objTpuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }

}
