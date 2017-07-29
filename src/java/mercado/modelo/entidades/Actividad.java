package mercado.modelo.entidades;

public class Actividad {

    private int idActividad;
    private String descripcion;
    private SubActividad subActividad;

    public Actividad() {
        subActividad = new SubActividad();
    }

    /**
     * @return the idActividad
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * @param idActividad the idActividad to set
     */
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
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
     * @return the subActividad
     */
    public SubActividad getSubActividad() {
        return subActividad;
    }

    /**
     * @param subActividad the subActividad to set
     */
    public void setSubActividad(SubActividad subActividad) {
        this.subActividad = subActividad;
    }

}
