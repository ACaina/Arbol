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
import mercado.modelo.entidades.Contrato;
import mercado.modelo.funciones.FContrato;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author ♥ Erika
 */
@ManagedBean
@ViewScoped
public class ControladorContrato implements Serializable {

    private ArrayList<Contrato> lstContrato;
    private Contrato objContrato;
    private Contrato contratoSel;
    private String msgBD;

    public ControladorContrato() {
        objContrato = new Contrato();
        contratoSel = new Contrato();
        obtenerContrato();
    }

    public void obtenerContrato() {
        try {
            lstContrato = FContrato.obtenerContrato();
            System.out.println("total Contrato: "+lstContrato.size());
        } catch (Exception e) {
            System.out.println("public void obtenerContrato() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FContrato.insertarContrato(objContrato);
            objContrato = new Contrato();
            obtenerContrato();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblContrato");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarContrato').hide()");
        } catch (Exception e) {
            
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            System.out.println("Entrar");         
            msgBD = FContrato.actualizarContrato(contratoSel);
            contratoSel = new Contrato();
            obtenerContrato();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblContrato");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarContrato').hide()");
        } catch (Exception e) {
            System.out.println("actualizar() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

     public void eliminar() {
        try {
            msgBD = FContrato.eliminarContrato(contratoSel);
            contratoSel = new Contrato();
            obtenerContrato();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblContrato");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarContrato').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Contrato> getLstContrato() {
        return lstContrato;
    }

    public void setLstContrato(ArrayList<Contrato> lstContrato) {
        this.lstContrato = lstContrato;
    }

    public Contrato getObjContrato() {
        return objContrato;
    }

    public void setObjContrato(Contrato objContrato) {
        this.objContrato = objContrato;
    }

    public Contrato getContratoSel() {
        return contratoSel;
    }

    public void setContratoSel(Contrato contratoSel) {
        this.contratoSel = contratoSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
}
