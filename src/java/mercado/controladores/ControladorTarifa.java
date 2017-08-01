/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controladores;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mercado.modelo.entidades.Seccion;
import mercado.modelo.entidades.Tarifa;
import mercado.modelo.entidades.Tpuesto;
import mercado.modelo.funciones.FSeccion;
import mercado.modelo.funciones.FTarifa;
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
public class ControladorTarifa {
    private ArrayList<Tarifa> lstTarifa;
    private ArrayList<Seccion> lstSeccion;
    private ArrayList<Tpuesto> lstTpuesto;
    private Tarifa objTarifa;
    private Tarifa tarifaSel;
    private String msgBD;

    public ControladorTarifa() {
        objTarifa = new Tarifa();
        tarifaSel = new Tarifa();
        obtenerSeccion();
        obtenerTarifa();
        obtenerTpuesto();
    }

    public void obtenerSeccion() {
        try {
            lstSeccion = FSeccion.obtenerSecciones();
//            System.out.println("total de PUESTOS: " + lstPuesto.size());
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

    public void obtenerTpuesto() {
        try {
            lstTpuesto = FTipoPuesto.obtenerTpuestos();
            System.out.println("total de MERCADO: "+lstTpuesto.size());
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        
        try {
            msgBD = FTarifa.insertarTarifa(objTarifa);
            objTarifa = new Tarifa();
            obtenerTarifa();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblPuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarPuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FTarifa.actualizarTarifa(tarifaSel);
            tarifaSel = new Tarifa();
            obtenerTarifa();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblPuesto");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarPuesto').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FTarifa.eliminarTarifa(tarifaSel);
            tarifaSel = new Tarifa();
            obtenerTarifa();
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

    public ArrayList<Tarifa> getLstTarifa() {
        return lstTarifa;
    }

    public void setLstTarifa(ArrayList<Tarifa> lstTarifa) {
        this.lstTarifa = lstTarifa;
    }

    public ArrayList<Seccion> getLstSeccion() {
        return lstSeccion;
    }

    public void setLstSeccion(ArrayList<Seccion> lstSeccion) {
        this.lstSeccion = lstSeccion;
    }

    public ArrayList<Tpuesto> getLstTpuesto() {
        return lstTpuesto;
    }

    public void setLstTpuesto(ArrayList<Tpuesto> lstTpuesto) {
        this.lstTpuesto = lstTpuesto;
    }

    public Tarifa getObjTarifa() {
        return objTarifa;
    }

    public void setObjTarifa(Tarifa objTarifa) {
        this.objTarifa = objTarifa;
    }

    public Tarifa getTarifaSel() {
        return tarifaSel;
    }

    public void setTarifaSel(Tarifa tarifaSel) {
        this.tarifaSel = tarifaSel;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }
    
    
}
