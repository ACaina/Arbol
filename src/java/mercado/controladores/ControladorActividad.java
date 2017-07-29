package mercado.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mercado.modelo.entidades.Actividad;
import mercado.modelo.entidades.SubActividad;
import mercado.modelo.funciones.FActividad;
import mercado.modelo.funciones.FSubActividad;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class ControladorActividad implements Serializable {

    private ArrayList<Actividad> lstActividades;
    private ArrayList<SubActividad> lstSubactividades;
    private Actividad objActividad;
    private Actividad actividadSel;
    private String msgBD;

    public ControladorActividad() {
        objActividad = new Actividad();
        actividadSel = new Actividad();
        obtenerActividades();
        obtenerSubactividades();
    }

    public void obtenerActividades() {
        try {
            lstActividades = FActividad.obtenerActividades();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerSubactividades() {
        try {
            lstSubactividades = FSubActividad.obtenerSubActividades();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {
            msgBD = FActividad.insertarActividad(objActividad);
            objActividad = new Actividad();
            obtenerActividades();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblActividad");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarActividad').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FActividad.actualizarActividad(actividadSel);
            actividadSel = new Actividad();
            obtenerActividades();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblActividad");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarActividad').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

     public void eliminar() {
        try {
            msgBD = FActividad.eliminarActividad(actividadSel);
            actividadSel = new Actividad();
            obtenerActividades();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblActividad");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarActividad').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public Actividad getObjActividad() {
        return objActividad;
    }

    public void setObjActividad(Actividad objActividad) {
        this.objActividad = objActividad;
    }

    public Actividad getActividadSel() {
        return actividadSel;
    }

    public void setActividadSel(Actividad actividadSel) {
        this.actividadSel = actividadSel;
    }

    public ArrayList<Actividad> getLstActividades() {
        return lstActividades;
    }

    public void setLstActividades(ArrayList<Actividad> lstActividades) {
        this.lstActividades = lstActividades;
    }

    public ArrayList<SubActividad> getLstSubactividades() {
        return lstSubactividades;
    }

    public void setLstSubactividades(ArrayList<SubActividad> lstSubactividades) {
        this.lstSubactividades = lstSubactividades;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }

}
