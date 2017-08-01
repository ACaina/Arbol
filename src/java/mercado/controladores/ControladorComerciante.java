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
import mercado.modelo.entidades.Comerciante;
import mercado.modelo.funciones.FComerciante;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author ♥ Erika
 */
@ManagedBean
@ViewScoped
public class ControladorComerciante implements Serializable {

    private ArrayList<Comerciante> lstComerciantes;
    private Comerciante objComerciante;
    private Comerciante comercianteSel;
    private String msgBD;

    public ControladorComerciante() {
        objComerciante = new Comerciante();
        comercianteSel = new Comerciante();
        obtenerComerciante();
    }

    public void obtenerComerciante() {
        try {
            lstComerciantes = FComerciante.obtenerComerciantes();
            System.out.println("total Comerciantes: "+lstComerciantes.size());
        } catch (Exception e) {
            System.out.println("public void obtenerComerciante() dice: "+e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FComerciante.insertarComerciante(objComerciante);
            objComerciante = new Comerciante();
            obtenerComerciante();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblComerciante");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarComerciante').hide()");
        } catch (Exception e) {
            
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            System.out.println("Entrar");         
            msgBD = FComerciante.actualizarComerciante(comercianteSel);
            System.out.println("Enkkkr");
            comercianteSel = new Comerciante();
            System.out.println("222");
            obtenerComerciante();
            Util.addSuccessMessage(msgBD);
            
            resetearFitrosTabla("frmPrincipal:tblComerciante");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarComerciante').hide()");
        } catch (Exception e) {
            System.out.println("actualizar() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

     public void eliminar() {
        try {
            msgBD = FComerciante.eliminarComerciante(comercianteSel);
            comercianteSel = new Comerciante();
            obtenerComerciante();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblComerciante");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarComerciante').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public Comerciante getObjComerciante() {
        return objComerciante;
    }

    public void setObjComerciante(Comerciante objComerciante) {
        this.objComerciante = objComerciante;
    }

    public Comerciante getComercianteSel() {
        return comercianteSel;
    }

    public void setComercianteSel(Comerciante comercianteSel) {
        this.comercianteSel = comercianteSel;
    }

    public ArrayList<Comerciante> getLstComerciante() {
        return lstComerciantes;
    }

    public void setLstComerciante(ArrayList<Comerciante> lstComerciantes) {
        this.lstComerciantes = lstComerciantes;
    }
   
    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }

}
