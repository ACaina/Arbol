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
public class Puesto {
    private int id_puesto;
    private String numero_puesto;
    private Tarifa Tarifa;
    private Mercado Mercado;

    public Puesto() {
        Tarifa = new Tarifa();
        Mercado = new Mercado();
    }

    public Puesto(int id_puesto, String numero_puesto, Tarifa Tarifa, Mercado Mercado) {
        this.id_puesto = id_puesto;
        this.numero_puesto = numero_puesto;
        this.Tarifa = Tarifa;
        this.Mercado = Mercado;
    }

    /**
     * @return the id_puesto
     */
    public int getId_puesto() {
        return id_puesto;
    }

    /**
     * @param id_puesto the id_puesto to set
     */
    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
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
     * @return the Tarifa
     */
    public Tarifa getTarifa() {
        return Tarifa;
    }

    /**
     * @param Tarifa the Tarifa to set
     */
    public void setTarifa(Tarifa Tarifa) {
        this.Tarifa = Tarifa;
    }

    /**
     * @return the Mercado
     */
    public Mercado getMercado() {
        return Mercado;
    }

    /**
     * @param Mercado the Mercado to set
     */
    public void setMercado(Mercado Mercado) {
        this.Mercado = Mercado;
    }
    
    
}
