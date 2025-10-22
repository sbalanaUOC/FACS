package modelo;
import java.util.ArrayList;

public class OnlineStore {

    // Atributos
    private ArrayList<Cliente> listadoClientes;
    private ArrayList<Pedido> listadoPedidos;
    private ArrayList<Articulo> listadoArticulos;

    // Constructor
    public OnlineStore() {
        this.listadoClientes = new ArrayList<>();
        this.listadoPedidos = new ArrayList<>();
        this.listadoArticulos = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(ArrayList<Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    public ArrayList<Pedido> getListadoPedidos() {
        return listadoPedidos;
    }

    public void setListadoPedidos(ArrayList<Pedido> listadoPedidos) {
        this.listadoPedidos = listadoPedidos;
    }

    public ArrayList<Articulo> getListadoArticulos() {
        return listadoArticulos;
    }

    public void setListadoArticulos(ArrayList<Articulo> listadoArticulos) {
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
    
    public void añadirCliente(Cliente c) {
        listadoClientes.add(c);
    }

    public void mostrarClientes() {

        System.out.println("\n===== opcion mostrar clientes =====");
    }

    public void mostrarClientesEstandar() {
        
    }

    public void mostrarClientesPremium() {
        
    }

    public void añadirArticulo(Articulo a) {
        listadoArticulos.add(a);
    }

    public void mostrarArticulos() {
        
    }

    public void añadirPedido(Pedido p) {
        listadoPedidos.add(p);
    }

    public void eliminarPedido(int num) {
        
    }

    public void mostrarPedidosPendientes(Cliente cliente) {
        
    }

    public void mostrarPedidosEnviados(Cliente cliente) {
        
    }
}
