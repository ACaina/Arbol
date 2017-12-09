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
    
   
    
    
}
