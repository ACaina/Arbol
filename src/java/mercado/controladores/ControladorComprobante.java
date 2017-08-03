package mercado.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import mercado.modelo.entidades.Comprobante;
import mercado.modelo.funciones.FComprobante;
import mercado.reportes.entidades.Reportes;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class ControladorComprobante implements Serializable {

    private ArrayList<Comprobante> lstComprobantes;
    private Comprobante objComprobante;
    private Comprobante comprobanteSel;

    public ControladorComprobante() {
        objComprobante = new Comprobante();
        objComprobante = new Comprobante();
        obtenerComprobantes();
    }

    public void obtenerComprobantes() {
        try {
            lstComprobantes = FComprobante.obtenerComprobantes();
        } catch (Exception e) {
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }

    public void verReporteGeneral() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Reportes reporte = new Reportes();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/reportes/ReporteComprobantes.jasper");
        reporte.getReporteGlobal(ruta);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void verReporteGeneral2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Reportes reporte = new Reportes();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        
        String ruta = servletContext.getRealPath("/reportes/Test.jasper");
        
        reporte.getReporteGlobal(ruta);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void eliminarComprobante() {
        try {
            String msgBD = FComprobante.eliminarComprobante(comprobanteSel);
            comprobanteSel = new Comprobante();
            obtenerComprobantes();
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msgBD, msgBD);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            resetearFitrosTabla("frmPrincipal:tblComprobante");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public ArrayList<Comprobante> getLstComprobantes() {
        return lstComprobantes;
    }

    public void setLstComprobantes(ArrayList<Comprobante> lstComprobantes) {
        this.lstComprobantes = lstComprobantes;
    }

    public Comprobante getObjComprobante() {
        return objComprobante;
    }

    public void setObjComprobante(Comprobante objComprobante) {
        this.objComprobante = objComprobante;
    }

    public Comprobante getComprobanteSel() {
        return comprobanteSel;
    }

    public void setComprobanteSel(Comprobante comprobanteSel) {
        this.comprobanteSel = comprobanteSel;
    }

}
