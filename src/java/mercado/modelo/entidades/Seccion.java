package mercado.modelo.entidades;

public class Seccion {

    private int idSeccion;
    private String nombre_seccion;
    private String estado;
    private double area;
    private String dimension;

    public Seccion() {
    }

    public Seccion(int idSeccion, String nombre_seccion, String estado, double area, String dimension) {
        this.idSeccion = idSeccion;
        this.nombre_seccion = nombre_seccion;
        this.estado = estado;
        this.area = area;
        this.dimension = dimension;
    }

//    /**
//     * @return the idSeccion
//     */
//    public int getIdSeccion() {
//        return idSeccion;
//    }
//
//    /**
//     * @param idSeccion the idSeccion to set
//     */
//    public void setIdSeccion(int idSeccion) {
//        this.idSeccion = idSeccion;
//    }
//
//    /**
//     * @return the nombre
//     */
//    public String getNombre() {
//        return nombre;
//    }
//
//    /**
//     * @param nombre the nombre to set
//     */
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    /**
//     * @return the estado
//     */
//    public int getEstado() {
//        return estado;
//    }
//
//    /**
//     * @param estado the estado to set
//     */
//    public void setEstado(int estado) {
//        this.estado = estado;
//    }
//
//    /**
//     * @return the dimension
//     */
//    public double getDimension() {
//        return dimension;
//    }
//
//    /**
//     * @param dimension the dimension to set
//     */
//    public void setDimension(double dimension) {
//        this.dimension = dimension;
//    }
    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombre_seccion() {
        return nombre_seccion;
    }

    public void setNombre_seccion(String nombre_seccion) {
        this.nombre_seccion = nombre_seccion;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
