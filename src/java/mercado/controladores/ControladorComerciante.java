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
public class ControladorComerciante  implements Serializable {
    private ArrayList<Comerciante> lstComerciante;;
    private Comerciante objComerciante;
    private Comerciante ComercianteSel;
    private String msgBD;

    public ControladorComerciante() {
        objComerciante = new Comerciante();
        ComercianteSel = new Comerciante();
        obtenerComerciante();
    }
    
    public void obtenerComerciante() {
        try {
            lstComerciante = FComerciante.obtenerComerciantes();
            System.out.println("Muestra Comerciantes ");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
    
    public void insertar() {
        try {
            System.out.println("Ingresa Comerciante");
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
            msgBD = FComerciante.actualizarComerciante(ComercianteSel);
            ComercianteSel = new Comerciante();
            obtenerComerciante();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblComerciante");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarComerciante').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FComerciante.eliminarComerciante(ComercianteSel);
            ComercianteSel = new Comerciante();
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

    public ArrayList<Comerciante> getLstComerciante() {
        return lstComerciante;
    }

    public void setLstComerciante(ArrayList<Comerciante> lstComerciante) {
        this.lstComerciante = lstComerciante;
    }

    public Comerciante getObjComerciante() {
        return objComerciante;
    }

    public void setObjComerciante(Comerciante objComerciante) {
        this.objComerciante = objComerciante;
    }

    public Comerciante getComercianteSel() {
        return ComercianteSel;
    }

    public void setComercianteSel(Comerciante ComercianteSel) {
        this.ComercianteSel = ComercianteSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
}
