package mercado.modelo.entidades;

public class SubActividad {

    private int idSubActividad;
    private String subActividad;

    public SubActividad() {
    }

    public SubActividad(int idSubActividad, String subActividad) {
        this.idSubActividad = idSubActividad;
        this.subActividad = subActividad;
    }

    /**
     * @return the idSubActividad
     */
    public int getIdSubActividad() {
        return idSubActividad;
    }

    /**
     * @param idSubActividad the idSubActividad to set
     */
    public void setIdSubActividad(int idSubActividad) {
        this.idSubActividad = idSubActividad;
    }

    /**
     * @return the subActividad
     */
    public String getSubActividad() {
        return subActividad;
    }

    /**
     * @param subActividad the subActividad to set
     */
    public void setSubActividad(String subActividad) {
        this.subActividad = subActividad;
    }

}
