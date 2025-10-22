
package modelo;

public class Articulo {

    private String Codigo;
    private String Descripcion;
    private float PrecioVenta;
    private float GastosEnvio;
    private int TiempoPreparacion;

    public Articulo(String codigo, String descripcion, float precioVenta, float gastosEnvio, int tiempoPreparacion) {
        Codigo = codigo;
        Descripcion = descripcion;
        PrecioVenta = precioVenta;
        GastosEnvio = gastosEnvio;
        TiempoPreparacion = tiempoPreparacion;
    }

    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public float getPrecioVenta() {
        return PrecioVenta;
    }
    public void setPrecioVenta(float precioVenta) {
        this.PrecioVenta = precioVenta;
    }

    public float getGastosEnvio() {
        return GastosEnvio;
    }
    public void setGastosEnvio(float gastosEnvio) {
        this.GastosEnvio = gastosEnvio;
    }

    public int getTiempoPreparacion() {
        return TiempoPreparacion;
    }
    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.TiempoPreparacion = tiempoPreparacion;
    }
}