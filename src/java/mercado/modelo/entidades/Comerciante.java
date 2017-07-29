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
public class Comerciante {

    private int id_comerciante;
    private String identificador;
    private int tipo_identificador;
    private String nombres_c;
    private String apellidos_c;
    private String direccion_c;
    private String correo_c;
    private int conadis;
    private String telefono;

    public Comerciante() {
    }

    public Comerciante(int id_comerciante, String identificador, int tipo_identificador, String nombres_c, String apellidos_c, String direccion_c, String correo_c, int conadis, String telefono) {
        this.id_comerciante = id_comerciante;
        this.identificador = identificador;
        this.tipo_identificador = tipo_identificador;
        this.nombres_c = nombres_c;
        this.apellidos_c = apellidos_c;
        this.direccion_c = direccion_c;
        this.correo_c = correo_c;
        this.conadis = conadis;
        this.telefono = telefono;
    }
    
    
    /**
     * @return the id_comerciante
     */
    public int getId_comerciante() {
        return id_comerciante;
    }

    /**
     * @param id_comerciante the id_comerciante to set
     */
    public void setId_comerciante(int id_comerciante) {
        this.id_comerciante = id_comerciante;
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the tipo_identificador
     */
    public int getTipo_identificador() {
        return tipo_identificador;
    }

    /**
     * @param tipo_identificador the tipo_identificador to set
     */
    public void setTipo_identificador(int tipo_identificador) {
        this.tipo_identificador = tipo_identificador;
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
     * @return the direccion_c
     */
    public String getDireccion_c() {
        return direccion_c;
    }

    /**
     * @param direccion_c the direccion_c to set
     */
    public void setDireccion_c(String direccion_c) {
        this.direccion_c = direccion_c;
    }

    /**
     * @return the correo_c
     */
    public String getCorreo_c() {
        return correo_c;
    }

    /**
     * @param correo_c the correo_c to set
     */
    public void setCorreo_c(String correo_c) {
        this.correo_c = correo_c;
    }

    /**
     * @return the conadis
     */
    public int getConadis() {
        return conadis;
    }

    /**
     * @param conadis the conadis to set
     */
    public void setConadis(int conadis) {
        this.conadis = conadis;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
