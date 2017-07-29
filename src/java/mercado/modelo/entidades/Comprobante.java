/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.modelo.entidades;

/**
 *
 * @author ♥ Erika
 */
public class Comprobante {
    private int id_comprobante;
    private double valor_cancelar;
    private double iva;
    private String numero_puesto;
    private String nombres_c;
    private String apellidos_c;
    private String fecha_emision;
    private int mes_pago;
    private int año_pago;
    private String nombre_seccion;
    private String tipo_puesto;
    private Contrato id_contrato;

    public Comprobante() {
        id_contrato= new Contrato();
    }
 
    public Comprobante(int id_comprobante, double valor_cancelar, double iva, String numero_puesto, String nombres_c, String apellidos_c, String fecha_emision, int mes_pago, int año_pago, String nombre_seccion, String tipo_puesto, Contrato id_contrato) {
        this.id_comprobante = id_comprobante;
        this.valor_cancelar = valor_cancelar;
        this.iva = iva;
        this.numero_puesto = numero_puesto;
        this.nombres_c = nombres_c;
        this.apellidos_c = apellidos_c;
        this.fecha_emision = fecha_emision;
        this.mes_pago = mes_pago;
        this.año_pago = año_pago;
        this.nombre_seccion = nombre_seccion;
        this.tipo_puesto = tipo_puesto;
        this.id_contrato = id_contrato;
    }

    
    
    /**
     * @return the id_comprobante
     */
    public int getId_comprobante() {
        return id_comprobante;
    }

    /**
     * @param id_comprobante the id_comprobante to set
     */
    public void setId_comprobante(int id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    /**
     * @return the valor_cancelar
     */
    public double getValor_cancelar() {
        return valor_cancelar;
    }

    /**
     * @param valor_cancelar the valor_cancelar to set
     */
    public void setValor_cancelar(double valor_cancelar) {
        this.valor_cancelar = valor_cancelar;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * @return the numero_puesto
     */
    public String getNumero_puesto() {
        return numero_puesto;
    }

    /**
     * @param numero_puesto the numero_puesto to set
     */
    public void setNumero_puesto(String numero_puesto) {
        this.numero_puesto = numero_puesto;
    }

    /**
     * @return the nombres_c
     */
    public String getNombres_c() {
        return nombres_c;
    }

    /**
     * @param nombres_c the nombres_c to set
     */
    public void setNombres_c(String nombres_c) {
        this.nombres_c = nombres_c;
    }

    /**
     * @return the apellidos_c
     */
    public String getApellidos_c() {
        return apellidos_c;
    }

    /**
     * @param apellidos_c the apellidos_c to set
     */
    public void setApellidos_c(String apellidos_c) {
        this.apellidos_c = apellidos_c;
    }

    /**
     * @return the fecha_emision
     */
    public String getFecha_emision() {
        return fecha_emision;
    }

    /**
     * @param fecha_emision the fecha_emision to set
     */
    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    /**
     * @return the mes_pago
     */
    public int getMes_pago() {
        return mes_pago;
    }

    /**
     * @param mes_pago the mes_pago to set
     */
    public void setMes_pago(int mes_pago) {
        this.mes_pago = mes_pago;
    }

    /**
     * @return the año_pago
     */
    public int getAño_pago() {
        return año_pago;
    }

    /**
     * @param año_pago the año_pago to set
     */
    public void setAño_pago(int año_pago) {
        this.año_pago = año_pago;
    }

    /**
     * @return the nombre_seccion
     */
    public String getNombre_seccion() {
        return nombre_seccion;
    }

    /**
     * @param nombre_seccion the nombre_seccion to set
     */
    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }

    /**
     * @return the tipo_puesto
     */
    public String getTipo_puesto() {
        return tipo_puesto;
    }

    /**
     * @param tipo_puesto the tipo_puesto to set
     */
    public void setTipo_puesto(String tipo_puesto) {
        this.tipo_puesto = tipo_puesto;
    }

    /**
     * @return the id_contrato
     */
    public Contrato getId_contrato() {
        return id_contrato;
    }

    /**
     * @param id_contrato the id_contrato to set
     */
    public void setId_contrato(Contrato id_contrato) {
        this.id_contrato = id_contrato;
    }
    
    
    
    
}
