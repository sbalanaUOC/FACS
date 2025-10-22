package modelo;
import java.time.LocalDateTime;

public class Pedido {

    //  atributos
    private int numpedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private int fecha;
    private EstadoPedido estado;

    public Pedido(int num_pedido, Cliente cliente, Articulo articulo, int cantidad, int fecha, EstadoPedido estado) {
        this.numpedido = num_pedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.estado = estado;
    }

    //  getters y setters
    public int getNum_pedido() {
        return numpedido;
    }
    public void setNum_pedido(int num_pedido) {
        this.numpedido = num_pedido;
    }

    public Cliente getClientes() {return cliente; }
    public void setClientes(Cliente clientes) {
        this.cliente = cliente;
    }

    public Articulo getArticulos() {
        return articulo;
    }
    public void setArticulos(Articulo articulos) {
        this.articulo = articulo;
    }

    public int getCantidades() {
        return cantidad;
    }
    public void setCantidades(int cantidades) {
        this.cantidad = cantidad;
    }

    public int getFecha() {
        return fecha;
    }
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }


    //  funciones
    public void CalcularImporteTotal(){
    }
    public void CalcularPeridodoAnulacion(){
    }
}