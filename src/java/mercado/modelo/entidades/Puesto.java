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
    private Tarifa id_tarifa;
    private Mercado id_mercado;

    public Puesto() {
        id_tarifa = new Tarifa();
        id_mercado = new Mercado();
    }

    public Puesto(int id_puesto, String numero_puesto, Tarifa id_tarifa, Mercado id_mercado) {
        this.id_puesto = id_puesto;
        this.numero_puesto = numero_puesto;
        this.id_tarifa = id_tarifa;
        this.id_mercado = id_mercado;
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
//    public int getNumero_puesto() {
//        return numero_puesto;
//    }
//
//    /**
//     * @param numero_puesto the numero_puesto to set
//     */
//    public void setNumero_puesto(int numero_puesto) {
//        this.numero_puesto = numero_puesto;
//    }
public String getNumero_puesto() {
        return numero_puesto;
    }

    public void setNumero_puesto(String numero_puesto) {
        this.numero_puesto = numero_puesto;
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

    /**
     * @return the id_mercado
     */
    public Mercado getId_mercado() {
        return id_mercado;
    }

    /**
     * @param id_mercado the id_mercado to set
     */
    public void setId_mercado(Mercado id_mercado) {
        this.id_mercado = id_mercado;
    }
    

   
    
}
