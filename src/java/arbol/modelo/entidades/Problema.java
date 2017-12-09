/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol.modelo.entidades;

import java.util.logging.Logger;

/**
 *
 * @author Jackeline
 */
public class Problema {
    private int id_problema;
    private String descripcion;
    private Causa fk_causa;
    private Involucrado fk_involucrado; 
       
    public Problema (){
        fk_causa = new Causa();
        fk_involucrado = new Involucrado;
    }

    public Problema(int id_problema, String descripcion, Causa fk_causa) {
        this.id_problema = id_problema;
        this.descripcion = descripcion;
        this.fk_causa = fk_causa;
    }

    public int getId_problema() {
        return id_problema;
    }

    public void setId_problema(int id_problema) {
        this.id_problema = id_problema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Causa getFk_causa() {
        return fk_causa;
    }

    public void setFk_causa(Causa fk_causa) {
        this.fk_causa = fk_causa;
    }

    public Involucrado getFk_involucrado() {
        return fk_involucrado;
    }

    public void setFk_involucrado(Involucrado fk_involucrado) {
        this.fk_involucrado = fk_involucrado;
    }
    
   
    
    
}
