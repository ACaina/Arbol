/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.modelo.entidades;

/**
 *
 * @author Morita
 */
public class Contrato {
    private int id_contrato;
    private String fecha_inicio;
    private String fecha_fin;
    private Comerciante id_comerciante;
    private Puesto id_puesto;
    private Actividad idActividad;

    public Contrato() {
    
    id_comerciante = new Comerciante();
    id_puesto =new Puesto();
    idActividad = new Actividad();
    }

    public Contrato(int id_contrato, String fecha_inicio, String fecha_fin, Comerciante id_comerciante, Puesto id_puesto, Actividad idActividad) {
        this.id_contrato = id_contrato;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_comerciante = id_comerciante;
        this.id_puesto = id_puesto;
        this.idActividad = idActividad;
    }

    /**
     * @return the id_contrato
     */
    public int getId_contrato() {
        return id_contrato;
    }

    /**
     * @param id_contrato the id_contrato to set
     */
    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    /**
     * @return the fecha_inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_fin
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the id_comerciante
     */
    public Comerciante getId_comerciante() {
        return id_comerciante;
    }

    /**
     * @param id_comerciante the id_comerciante to set
     */
    public void setId_comerciante(Comerciante id_comerciante) {
        this.id_comerciante = id_comerciante;
    }

    /**
     * @return the id_puesto
     */
    public Puesto getId_puesto() {
        return id_puesto;
    }

    /**
     * @param id_puesto the id_puesto to set
     */
    public void setId_puesto(Puesto id_puesto) {
        this.id_puesto = id_puesto;
    }

    /**
     * @return the idActividad
     */
    public Actividad getIdActividad() {
        return idActividad;
    }

    /**
     * @param idActividad the idActividad to set
     */
    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }
    
}
