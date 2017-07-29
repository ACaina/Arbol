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
public class Mercado {
    private int id_mercado;
    private String nombre_mercado;
    private String estado;

    public Mercado() {
    }

    public Mercado(int id_mercado, String nombre_mercado, String estado) {
        this.id_mercado = id_mercado;
        this.nombre_mercado = nombre_mercado;
        this.estado = estado;
    }

    /** 
     * @return the id_mercado
     */
    public int getId_mercado() {
        return id_mercado;
    }

    /**
     * @param id_mercado the id_mercado to set
     */
    public void setId_mercado(int id_mercado) {
        this.id_mercado = id_mercado;
    }

    /**
     * @return the nombre_mercado
     */
    public String getNombre_mercado() {
        return nombre_mercado;
    }

    /**
     * @param nombre_mercado the nombre_mercado to set
     */
    public void setNombre_mercado(String nombre_mercado) {
        this.nombre_mercado = nombre_mercado;
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
    
    
    
}
