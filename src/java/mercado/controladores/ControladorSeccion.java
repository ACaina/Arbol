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
import mercado.modelo.entidades.Seccion;
import mercado.modelo.funciones.FSeccion;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author caina
 */
@ManagedBean
@ViewScoped
public class ControladorSeccion implements Serializable{

    private ArrayList<Seccion> lstSecciones;
    private Seccion seccionSel;
    private Seccion objSeccion;
    private String estado;
//    private int id;
    private String msgBD;

    public ControladorSeccion() {
        objSeccion = new Seccion();
        seccionSel = new Seccion();
        obtenerSecciones();
    }

    public void obtenerSecciones() {
        try {
            lstSecciones = FSeccion.obtenerSecciones();
            System.out.println("Muestra secciones ");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void obtenerSeccionesDadoEstado() {
        try {
            lstSecciones = FSeccion.obtenerSeccionesDadoEstado(estado);
        } catch (Exception e) {
            System.out.println("public void obtenerSeccionesDadoEstado() dice: " + e.getMessage());
            Util.addErrorMessage("public void obtenerSeccionesDadoEstado() dice: " + e.getMessage());
        }
    }

    public void insertar() {
        try {
            System.out.println("Ingresa insertar ");
            msgBD = FSeccion.insertarSesion(objSeccion);
            objSeccion = new Seccion();
            obtenerSecciones();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblSeccion");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgInsertarSeccion').hide()");
        } catch (Exception e) {

            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizar() {
        try {
            msgBD = FSeccion.actualizarSeccion(seccionSel);
            seccionSel = new Seccion();
            obtenerSecciones();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblSeccion");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarSeccion').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminar() {
        try {
            msgBD = FSeccion.eliminarSeccion(seccionSel);
            seccionSel = new Seccion();
            obtenerSecciones();
            Util.addSuccessMessage(msgBD);
            resetearFitrosTabla("frmPrincipal:tblSeccion");
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarSeccion').hide()");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public Seccion getSeccionSel() {
        return seccionSel;
    }

    public void setSeccionSel(Seccion seccionSel) {
        this.seccionSel = seccionSel;
    }

    public ArrayList<Seccion> getLstSecciones() {
        return lstSecciones;
    }

    public String getMsgBD() {
        return msgBD;
    }

    public void setMsgBD(String msgBD) {
        this.msgBD = msgBD;
    }

    public void setLstSecciones(ArrayList<Seccion> lstSecciones) {
        this.lstSecciones = lstSecciones;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Seccion getObjSeccion() {
        return objSeccion;
    }

    public void setObjSeccion(Seccion objSeccion) {
        this.objSeccion = objSeccion;
    }

//    /**
//     * @return the id
//     */
//    public int getId() {
//        return id;
//    }
//
//    /**
//     * @param id the id to set
//     */
//    public void setId(int id) {
//        this.id = id;
//    }

}
