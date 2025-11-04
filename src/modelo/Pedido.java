package modelo;
import java.time.LocalDateTime;

public class Pedido {
    private static int contador=0;
    //  atributos
    private int numpedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private LocalDateTime fecha;
    private EstadoPedido estado;





    public Pedido( Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fecha, EstadoPedido estado) {
        this.numpedido = ++contador;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Pedido( Cliente cliente, Articulo articulo, int cantidad) {
        this.numpedido = ++contador;            //automatico
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();       //automatico
        this.estado = EstadoPedido.Pendiente;   //automatico
    }

    //  getters y setters
    public int getNum_pedido() {
        return numpedido;
    }
    public void setNum_pedido(int num_pedido) {
        this.numpedido = num_pedido;
    }

    public Cliente getCliente() {return cliente; }
    public void setCliente(Cliente clientes) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }
    public void setArticulo(Articulo articulos) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidades) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }


    //  funciones

    // Importe total de pedido
    public float CalcularImporteTotal() {
        float precioVenta = articulo.getPrecioVenta();
        float gastosEnvio = articulo.getGastosEnvio();

        float total = precioVenta * cantidad + gastosEnvio;

        if (cliente instanceof ClientePremium premium) {
            float descuento = premium.calcularDescuentoEnvio(gastosEnvio);
            total -= descuento;
        }

        return total;
    }

    public void CalcularPeridodoAnulacion(){
    }
}