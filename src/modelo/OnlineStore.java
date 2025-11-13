package modelo;
import java.util.ArrayList;

import DAO.ArticuloDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;

import DTO.ArticuloDAO_DTO;
import DTO.ClienteDAO_DTO;
import DTO.PedidoDAO_DTO;

public class OnlineStore {



    // Atributos
    private static ArrayList<Cliente> listadoClientes;
    private static ArrayList<ClienteEstandar> listadoClienteEstandar;
    private static ArrayList<ClientePremium> listadoClientePremium;
    private ArrayList<Pedido> listadoPedidos;
    private ArrayList<Articulo> listadoArticulos;

    private static ClienteDAO clienteDao;
    private ArticuloDAO articuloDao;
    private PedidoDAO pedidoDao;


    // Constructor
    public OnlineStore() {
        this.listadoClientes = new ArrayList<>();
        this.listadoClienteEstandar = new ArrayList<>();
        this.listadoClientePremium = new ArrayList<>();
        this.listadoPedidos = new ArrayList<>();
        this.listadoArticulos = new ArrayList<>();

        this.clienteDao=new ClienteDAO_DTO();
        this.articuloDao=new ArticuloDAO_DTO();
        this.pedidoDao=new PedidoDAO_DTO();

    }


    //***********************************************************************************************//
    public void añadirArticulo(Articulo a){
        articuloDao.Create(a);
        //listadoArticulos.add(a);
    }

    public ArrayList<Articulo> getListadoArticulos()  {
        return articuloDao.Read_all();
    }

    //***********************************************************************************************//

    public static void añadirCliente(Cliente c) {

        clienteDao.CreateWithIndex(c);
        //Integer temp = clienteDao.CreateWithIndex(c);
        //c.setIdCliente(temp);

    }


    public ArrayList<Cliente> getListadoClientes() {
        return clienteDao.Read_all();
    }


    public ArrayList<Cliente> getListadoClienteEstandar(){
        return clienteDao.Read_STD();
       // return listadoClienteEstandar;
    }
    public ArrayList<Cliente> getListadoClientePremium() {
        return clienteDao.Read_PRM();
       // return listadoClientePremium;
    }

//*********************************************************************************************************************//
//*********************************************************************************************************************//


    public void añadirPedido(Pedido p) {
        pedidoDao.Create(p);
        //   listadoPedidos.add(p);
    }


    public void eliminarPedido(Pedido p) {

        pedidoDao.DeleteWithID(p.getNum_pedido());
        //pedidoDao.Delete(p);
      //    listadoPedidos.remove(p);
    }







    public void setListadoClientes(ArrayList<Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }
    public void setListadoClienteEstandar(ArrayList<ClienteEstandar> listadoClienteEstandar) {
        this.listadoClienteEstandar = listadoClienteEstandar;
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






    public void setListadoArticulos(ArrayList<Articulo> listadoArticulos) {
        this.listadoArticulos = listadoArticulos;
    }


    public ArrayList<Pedido> getListadoPedidosPendientes() {
        ArrayList<Pedido> pendientes = new ArrayList<>();
        for (Tablapedido tp : pedidoDao.Read_Tabla()) {
                 Pedido p = null;


            if (p.getEstado().equals(EstadoPedido.Pendiente)) { // O si es boolean: if(p.isPendiente())
                pendientes.add(p);
            }
        }
        return pendientes;
    }

    public ArrayList<Pedido> getListadoPedidosFinalizados() {
        ArrayList<Pedido> finalizados = new ArrayList<>();
        for (Pedido p : pedidoDao.Read_all()) {
            if (p.getEstado().equals(EstadoPedido.Finalizado)) { // O si es boolean: if(p.isPendiente())
                finalizados.add(p);
            }
        }
        return finalizados;
    }






}