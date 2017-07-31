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
import mercado.modelo.entidades.Mercado;
import mercado.modelo.entidades.Puesto;
import mercado.modelo.entidades.Tarifa;
import mercado.modelo.funciones.FMercado;
import mercado.modelo.funciones.FPuesto;
import mercado.modelo.funciones.FTarifa;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorPuesto implements Serializable {

    private ArrayList<Puesto> lstPuesto;
    private ArrayList<Tarifa> lstTarifa;
    private ArrayList<Mercado> lstMercado;
    private Puesto objPuesto;
    private Puesto puestoSel;
    private String msgBD;

    public ControladorPuesto() {
        objPuesto = new Puesto();
        puestoSel = new Puesto();
        obtenerPuesto();
        obtenerTarifa();
        obtenerMercado();
    }

    public void obtenerPuesto() {
        try {
            lstPuesto = FPuesto.obtenerPuestos();
            System.out.println("total de PUESTOS: " + lstPuesto.size());
        } catch (Exception e) {
//            System.out.println("public void obtenerActividades() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerTarifa() {
        try {
            lstTarifa = FTarifa.obtenerTarifas();
            System.out.println("total de TARIFAS: "+lstTarifa.size());
        } catch (Exception e) {
            System.out.println("public void obtenerTarifa() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerMercado() {
        try {
            lstMercado = FMercado.obtenerMercados();
            System.out.println("total de MERCADO: "+lstMercado.size());
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FPuesto.insertarPuesto(objPuesto);
            objPuesto = new Puesto();
            obtenerPuesto();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblPuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarPuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FPuesto.actualizarPuesto(puestoSel);
            puestoSel = new Puesto();
            obtenerPuesto();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblPuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarPuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FPuesto.eliminarPuesto(puestoSel);
            puestoSel = new Puesto();
            obtenerPuesto();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblPuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarPuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Puesto> getLstPuesto() {
        return lstPuesto;
    }

    public void setLstPuesto(ArrayList<Puesto> lstPuesto) {
        this.lstPuesto = lstPuesto;
    }

    public ArrayList<Tarifa> getLstTarifa() {
        return lstTarifa;
    }

    public void setLstTarifa(ArrayList<Tarifa> lstTarifa) {
        this.lstTarifa = lstTarifa;
    }

    public ArrayList<Mercado> getLstMercado() {
        return lstMercado;
    }

    public void setLstMercado(ArrayList<Mercado> lstMercado) {
        this.lstMercado = lstMercado;
    }

    public Puesto getObjPuesto() {
        return objPuesto;
    }

    public void setObjPuesto(Puesto objPuesto) {
        this.objPuesto = objPuesto;
    }

    public Puesto getPuestoSel() {
        return puestoSel;
    }

    public void setPuestoSel(Puesto puestoSel) {
        this.puestoSel = puestoSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }

}
