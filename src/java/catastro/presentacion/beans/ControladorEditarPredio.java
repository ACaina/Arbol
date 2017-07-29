package catastro.presentacion.beans;

import catastro.logica.entidades.Barrio;
import catastro.logica.entidades.Calle;
import catastro.logica.entidades.PredioV2;
import catastro.logica.servicios.FuncionesPredio;
import catastro.logica.servicios.ServiciosBarrios;
import catastro.logica.servicios.ServiciosCalles;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class ControladorEditarPredio implements Serializable {

    private String claveCatastral;
    private PredioV2 objPredio;
    private ArrayList<Barrio> lstBarrios;
    private ArrayList<Calle> lstCalles;

    public ControladorEditarPredio() {
        objPredio = new PredioV2();
        seleccionarBarrios();
    }

    public void obtenerPredio() {
        try {
            setObjPredio(FuncionesPredio.obtenerPredioDadoClaveCatastral(getClaveCatastral()));
        } catch (Exception e) {
            //  Util.addErrorMessage("public void obtenerPredio() dice: " + e.getMessage());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Método para seleccionar todos barrios">    
    public void seleccionarBarrios() {
        try {
            this.setLstBarrios(ServiciosBarrios.seleccionarBarrios());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
            System.out.println("Seleccionar barrios dice: " + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Método para seleccionar las calles">    
    public void seleccionarCalles() {
        try {
            this.setLstCalles(ServiciosCalles.obtenerCalles());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Seleccionar Calles dice: " + e.getMessage()));
            System.out.println("Seleccionar Calles dice: " + e.getMessage());
        }
    }
    //</editor-fold>

    /**
     * @return the claveCatastral
     */
    public String getClaveCatastral() {
        return claveCatastral;
    }

    /**
     * @param claveCatastral the claveCatastral to set
     */
    public void setClaveCatastral(String claveCatastral) {
        this.claveCatastral = claveCatastral;
    }

    /**
     * @return the objPredio
     */
    public PredioV2 getObjPredio() {
        return objPredio;
    }

    /**
     * @param objPredio the objPredio to set
     */
    public void setObjPredio(PredioV2 objPredio) {
        this.objPredio = objPredio;
    }

    /**
     * @return the lstBarrios
     */
    public ArrayList<Barrio> getLstBarrios() {
        return lstBarrios;
    }

    /**
     * @param lstBarrios the lstBarrios to set
     */
    public void setLstBarrios(ArrayList<Barrio> lstBarrios) {
        this.lstBarrios = lstBarrios;
    }

    /**
     * @return the lstCalles
     */
    public ArrayList<Calle> getLstCalles() {
        return lstCalles;
    }

    /**
     * @param lstCalles the lstCalles to set
     */
    public void setLstCalles(ArrayList<Calle> lstCalles) {
        this.lstCalles = lstCalles;
    }
}
