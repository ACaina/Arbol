package mercado.modelo.entidades;

public class Seccion {

    private int idSeccion;
    private String nombre;
    private int estado;
    private double dimension;

    /**
     * @return the idSeccion
     */
    public int getIdSeccion() {
        return idSeccion;
    }

    /**
     * @param idSeccion the idSeccion to set
     */
    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the dimension
     */
    public double getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(double dimension) {
        this.dimension = dimension;
    }
}
