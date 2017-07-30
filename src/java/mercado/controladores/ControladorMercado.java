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
import mercado.modelo.funciones.FMercado;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorMercado implements Serializable {
    private ArrayList<Mercado> lstMercado;
    private Mercado mercadoSel;
    private Mercado objMercado;
//    private int id;
    private String msgBD;

    public ControladorMercado() {
        objMercado = new Mercado();
        mercadoSel = new Mercado();
        obtenerMercado();
    }

    public void obtenerMercado() {
        try {
            lstMercado = FMercado.obtenerMercados();
            System.out.println("Muestra secciones ");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            System.out.println("Ingresa insertar ");
            msgBD = FMercado.insertarMercado(objMercado);
            objMercado = new Mercado();
            obtenerMercado();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblMercado");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarMercado').hide()");
        } catch (Exception e) {

            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FMercado.actualizarMercado(mercadoSel);
            mercadoSel = new Mercado();
            obtenerMercado();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblMercado");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarMercado').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FMercado.eliminarMercado(mercadoSel);
            mercadoSel = new Mercado();
            obtenerMercado();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblMercado");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarMercado').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Mercado> getLstMercado() {
        return lstMercado;
    }

    public void setLstMercado(ArrayList<Mercado> lstMercado) {
        this.lstMercado = lstMercado;
    }

    public Mercado getMercadoSel() {
        return mercadoSel;
    }

    public void setMercadoSel(Mercado mercadoSel) {
        this.mercadoSel = mercadoSel;
    }

    public Mercado getObjMercado() {
        return objMercado;
    }

    public void setObjMercado(Mercado objMercado) {
        this.objMercado = objMercado;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }

}
