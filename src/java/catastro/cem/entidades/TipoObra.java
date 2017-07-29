package catastro.cem.entidades;

import java.sql.Timestamp;

public class TipoObra {

    private int idTipoObra;
    private String tipoObra;
    private String descripcion;
    private String estadoLogico;
    private Timestamp fechaRegistro;
    private Timestamp fechaActualizacion;
    private Timestamp fechaBaja;

    /**
     * @return the idTipoObra
     */
    public int getIdTipoObra() {
        return idTipoObra;
    }

    /**
     * @param idTipoObra the idTipoObra to set
     */
    public void setIdTipoObra(int idTipoObra) {
        this.idTipoObra = idTipoObra;
    }

    /**
     * @return the tipoObra
     */
    public String getTipoObra() {
        return tipoObra;
    }

    /**
     * @param tipoObra the tipoObra to set
     */
    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estadoLogico
     */
    public String getEstadoLogico() {
        return estadoLogico;
    }

    /**
     * @param estadoLogico the estadoLogico to set
     */
    public void setEstadoLogico(String estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    /**
     * @return the fechaRegistro
     */
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the fechaActualizacion
     */
    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion the fechaActualizacion to set
     */
    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @return the fechaBaja
     */
    public Timestamp getFechaBaja() {
        return fechaBaja;
    }

    /**
     * @param fechaBaja the fechaBaja to set
     */
    public void setFechaBaja(Timestamp fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

}
