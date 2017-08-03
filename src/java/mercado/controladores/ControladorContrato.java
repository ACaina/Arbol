/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import mercado.modelo.entidades.Actividad;
import mercado.modelo.entidades.Comerciante;
import mercado.modelo.entidades.Contrato;
import mercado.modelo.entidades.Puesto;
import mercado.modelo.funciones.FActividad;
import mercado.modelo.funciones.FComerciante;
import mercado.modelo.funciones.FContrato;
import mercado.modelo.funciones.FPuesto;
import mercado.reportes.entidades.Reportes;
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
    private ArrayList<Puesto> lstPuesto;
    private ArrayList<Comerciante> lstComerciante;
    private ArrayList<Actividad> lstActividad;
    private Contrato objContrato;
    private Contrato contratoSel;
    private String msgBD;
    private String parametro;
    private Date fechaInicio;
    private Date fechaFin;

    public ControladorContrato() {
        objContrato = new Contrato();
        contratoSel = new Contrato();
        obtenerContrato();
        obtenerPuesto();
        obtenerComerciante();
        obtenerActividad();
    }

    public void obtenerContrato() {
        try {
            lstContrato = FContrato.obtenerContrato();
            System.out.println("total de Contrato: " + lstContrato.size());
        } catch (Exception e) {
//            System.out.println("public void obtenerActividades() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
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

    public void obtenerComerciante() {
        try {
            lstComerciante = FComerciante.obtenerComerciantes();
            System.out.println("total de Comerciante: " + lstComerciante.size());
        } catch (Exception e) {
            System.out.println("public void obtenerComerciante() dice: " + e.getMessage());
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerActividad() {
        try {
            lstActividad = FActividad.obtenerActividades();
            System.out.println("total de Actividad: " + lstActividad.size());
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void insertar() {
        try {

            DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
            String strFechaInicio = fecha.format(fechaInicio);
            String strFechaFin = fecha.format(fechaFin);
            objContrato.setFecha_inicio(strFechaInicio);
            objContrato.setFecha_fin(strFechaFin);

            System.out.println("Fecha inicio: " + strFechaInicio + "\n\n\n fecha fin: " + strFechaFin + "\n\n\n");

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
            msgBD = FContrato.actualizarContrato(contratoSel);
            contratoSel = new Contrato();
            obtenerContrato();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblContrato");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarContrato').hide()");
        } catch (Exception e) {
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

    public void encontrarContratos() {
        try {
            lstContrato = FContrato.econtrarContratos(parametro);
        } catch (Exception e) {
            System.out.println("public void encontrarContratos() dice: " + e.getMessage());
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }

    public void verReporteGeneral() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Reportes reporte = new Reportes();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/RepContratoGlobal.jasper");
        reporte.getReporteGlobal(ruta);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void verReporteIndividual() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Reportes reporte = new Reportes();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/RepContratoIndividual.jasper");
        reporte.getReportePdfPorId(ruta, contratoSel.getId_contrato());
        FacesContext.getCurrentInstance().responseComplete();
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

    public ArrayList<Puesto> getLstPuesto() {
        return lstPuesto;
    }

    public void setLstPuesto(ArrayList<Puesto> lstPuesto) {
        this.lstPuesto = lstPuesto;
    }

    public ArrayList<Comerciante> getLstComerciante() {
        return lstComerciante;
    }

    public void setLstComerciante(ArrayList<Comerciante> lstComerciante) {
        this.lstComerciante = lstComerciante;
    }

    public ArrayList<Actividad> getLstActividad() {
        return lstActividad;
    }

    public void setLstActividad(ArrayList<Actividad> lstActividad) {
        this.lstActividad = lstActividad;
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

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
