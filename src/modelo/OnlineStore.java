package modelo;
import java.util.ArrayList;

public class OnlineStore {


    // Atributos
    private static ArrayList<Cliente> listadoClientes;
    private static ArrayList<ClienteEstandar> listadoClienteEstandar;
    private static ArrayList<ClientePremium> listadoClientePremium;
    private ArrayList<Pedido> listadoPedidos;
    private ArrayList<Articulo> listadoArticulos;

    // Constructor
    public OnlineStore() {
        this.listadoClientes = new ArrayList<>();
        this.listadoClienteEstandar = new ArrayList<>();
        this.listadoClientePremium = new ArrayList<>();
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

    public ArrayList<ClienteEstandar> getListadoClienteEstandar() {
        return listadoClienteEstandar;
    }
    public void setListadoClienteEstandar(ArrayList<ClienteEstandar> listadoClienteEstandar) {
        this.listadoClienteEstandar = listadoClienteEstandar;
    }

    public ArrayList<ClientePremium> getListadoClientePremium() {
        return listadoClientePremium;
    }
    public void setListadoClientePremium(ArrayList<ClientePremium> listadoClientePremium) {
        this.listadoClientePremium = listadoClientePremium;
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


    public ArrayList<Pedido> getListadoPedidosPendientes() {
        ArrayList<Pedido> pendientes = new ArrayList<>();
        for (Pedido p : listadoPedidos) {
            if (p.getEstado().equals(EstadoPedido.Pendiente)) { // O si es boolean: if(p.isPendiente())
                pendientes.add(p);
            }
        }
        return pendientes;
    }

    public ArrayList<Pedido> getListadoPedidosFinalizados() {
        ArrayList<Pedido> finalizados = new ArrayList<>();
        for (Pedido p : listadoPedidos) {
            if (p.getEstado().equals(EstadoPedido.Finalizado)) { // O si es boolean: if(p.isPendiente())
                finalizados.add(p);
            }
        }
        return finalizados;
    }



    //Funciones

    public static void añadirCliente(Cliente c) {listadoClientes.add(c);}

    public static void añadirClienteEstandar(ClienteEstandar cS) {
        listadoClienteEstandar.add(cS);
    }

    public static void añadirClientePremium(ClientePremium cP) {
        listadoClientePremium.add(cP);
    }

    public void añadirArticulo(Articulo a) {listadoArticulos.add(a);}

    public void añadirPedido(Pedido p) {listadoPedidos.add(p);}


    public void eliminarPedido(Pedido p) {listadoPedidos.remove(p);


    }

}