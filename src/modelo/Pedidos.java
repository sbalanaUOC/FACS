package modelo;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Pedidos {

    //  atributos
    private int num_pedido;
    private String clientes;
    private String articulos;
    private int cantidades;
    private LocalDateTime fecha;
    private Scanner teclado;
    private EstadoPedidos estado;

    //  constructores
    public Pedidos() {
        this.num_pedido = num_pedido;
        this.clientes = clientes;
        this.articulos = articulos;
        this.cantidades = cantidades;
        this.fecha = fecha;
        this.estado = estado;
        this.teclado = new Scanner(System.in);
    }

    //  getters y setters
    public int getNum_pedido() {
        return num_pedido;
    }
    public void setNum_pedido(int num_pedido) {
        this.num_pedido = num_pedido;
    }


    public String getClientes() {return clientes; }
    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getArticulos() {
        return articulos;
    }
    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    public int getCantidades() {
        return cantidades;
    }
    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoPedidos getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedidos estado) {
        this.estado = estado;
    }


    //  funciones
    public void CalcularImporteTotal(){
    }
    public void CalcularPeridodoAnulacion(){
    }
}