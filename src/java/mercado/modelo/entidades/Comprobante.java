/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.modelo.entidades;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author ♥ Erika
 */
public class Comprobante {
    private int id_comprobante;
    private double iva;
    private Timestamp fecha_emision;
    private Date mes_pago;
    private Date  año_pago;
    private Contrato id_contrato;
    private Tarifa id_tarifa;
    



    public Comprobante() {
        id_contrato= new Contrato();
        id_tarifa= new Tarifa();  
        
    }

    public Comprobante(int id_comprobante, double iva, Timestamp fecha_emision, Date mes_pago, Date año_pago, Contrato id_contrato, Tarifa id_tarifa) {
        this.id_comprobante = id_comprobante;
        this.iva = iva;
        this.fecha_emision = fecha_emision;
        this.mes_pago = mes_pago;
        this.año_pago = año_pago;
        this.id_contrato = id_contrato;
        this.id_tarifa = id_tarifa;
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
     * @return the fecha_emision
     */
    public Timestamp getFecha_emision() {
        return fecha_emision;
    }

    /**
     * @param fecha_emision the fecha_emision to set
     */
    public void setFecha_emision(Timestamp fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    /**
     * @return the mes_pago
     */
    public Date getMes_pago() {
        return mes_pago;
    }

    /**
     * @param mes_pago the mes_pago to set
     */
    public void setMes_pago(Date mes_pago) {
        this.mes_pago = mes_pago;
    }

    /**
     * @return the año_pago
     */
    public Date getAño_pago() {
        return año_pago;
    }

    /**
     * @param año_pago the año_pago to set
     */
    public void setAño_pago(Date año_pago) {
        this.año_pago = año_pago;
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

    /**
     * @return the id_tarifa
     */
    public Tarifa getId_tarifa() {
        return id_tarifa;
    }

    /**
     * @param id_tarifa the id_tarifa to set
     */
    public void setId_tarifa(Tarifa id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

   
    
}
