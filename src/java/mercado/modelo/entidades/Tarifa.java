package mercado.modelo.entidades;

public class Tarifa {
    
private int idTarifa;
    private String valor_tarifa;
    private Seccion idSeccion;
    private Tpuesto id_tipo_puesto;

    public Tarifa() {
        idSeccion=new Seccion();
        id_tipo_puesto=new Tpuesto();
    }

    public Tarifa(int idTarifa, String valor_tarifa, Seccion idSeccion, Tpuesto id_tipo_puesto) {
        this.idTarifa = idTarifa;
        this.valor_tarifa = valor_tarifa;
        this.idSeccion = idSeccion;
        this.id_tipo_puesto = id_tipo_puesto;
    }
  
    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getValor_tarifa() {
        return valor_tarifa;
    }

    public void setValor_tarifa(String valor_tarifa) {
        this.valor_tarifa = valor_tarifa;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Tpuesto getId_tipo_puesto() {
        return id_tipo_puesto;
    }

    public void setId_tipo_puesto(Tpuesto id_tipo_puesto) {
        this.id_tipo_puesto = id_tipo_puesto;
    }
    
    
    
}
