package mercado.modelo.entidades;

public class Tpuesto {
   

    private int id_tipo_puesto;
    private String descripcion_tipo_puesto;

    public Tpuesto() {
    }

    public Tpuesto(int id_tipo_puesto, String descripcion_tipo_puesto) {
        this.id_tipo_puesto = id_tipo_puesto;
        this.descripcion_tipo_puesto = descripcion_tipo_puesto;
    }

    public int getId_tipo_puesto() {
        return id_tipo_puesto;
    }

    public void setId_tipo_puesto(int id_tipo_puesto) {
        this.id_tipo_puesto = id_tipo_puesto;
    }

    public String getDescripcion_tipo_puesto() {
        return descripcion_tipo_puesto;
    }

    public void setDescripcion_tipo_puesto(String descripcion_tipo_puesto) {
        this.descripcion_tipo_puesto = descripcion_tipo_puesto;
    }
    
}
