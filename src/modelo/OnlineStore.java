package modelo;
import java.util.ArrayList;

public class OnlineStore {

    // Atributos
    private ArrayList<Clientes> listadoClientes;
    private ArrayList<Pedidos> listadoPedidos;
    private ArrayList<Articulos> listadoArticulos;

    // Constructor
    public OnlineStore() {
        this.listadoClientes = new ArrayList<>();
        this.listadoPedidos = new ArrayList<>();
        this.listadoArticulos = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<Clientes> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(ArrayList<Clientes> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    public ArrayList<Pedidos> getListadoPedidos() {
        return listadoPedidos;
    }

    public void setListadoPedidos(ArrayList<Pedidos> listadoPedidos) {
        this.listadoPedidos = listadoPedidos;
    }

    public ArrayList<Articulos> getListadoArticulos() {
        return listadoArticulos;
    }

    public void setListadoArticulos(ArrayList<Articulos> listadoArticulos) {
        this.listadoArticulos = listadoArticulos;
    }
    @Override
    public String toString() {
        return "OnlineStore {" +
                "Clientes=" + listadoClientes.size() +
                ", Pedidos=" + listadoPedidos.size() +
                ", Artículos=" + listadoArticulos.size() +
                '}';
    }

    //Funciones
    
    public void añadirCliente(Clientes c) {
        
    }

    public void mostrarClientes() {
        
    }

    public void mostrarClientesEstandar() {
        
    }

    public void mostrarClientesPremium() {
        
    }

    public void añadirArticulo(Articulos a) {
        
    }

    public void mostrarArticulos() {
        
    }

    public void añadirPedido(Pedidos p) {
        
    }

    public void eliminarPedido(int num) {
        
    }

    public void mostrarPedidosPendientes(Clientes cliente) {
        
    }

    public void mostrarPedidosEnviados(Clientes cliente) {
        
    }
}
