package controlador;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.EstadoPedido;
import modelo.Modelo;
import modelo.OnlineStore;
import vista.Vista;



public class Controlador {

    private Modelo modelo;
    private Vista vista;

    OnlineStore tienda= new OnlineStore();


    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public Modelo getModelo() {return modelo;}
    public void setModelo(Modelo modelo) {this.modelo = modelo;}
    public Vista getVista() {return vista;}
    public void setVista(Vista vista) {this.vista = vista;}


    // Métodos que conectan vista y modelo

    public void iniciarPrograma() {
        int opcion;

     // OnlineStore tienda= new OnlineStore();

      ValoresInicio();

        do {
            opcion = vista.mostrarMenuPrincipal();
            procesarOpcionPrincipal(opcion);
        } while (opcion != 0);
    }

    private void procesarOpcionPrincipal(int opcion) {
        switch (opcion) {
            case 11:
                //  opcion Añadir artículo
                break;
            case 12:
                  //  opcion Mostrar articulos
                vista.MostrarArticulos();
                break;
            case 21:
                //  opcion Añadir cliente
                break;
            case 22:
                //  opcion   Mostrar clientes
                 ArrayList<modelo.Cliente> clientes = tienda.getListadoClientes();

                for (Cliente c : clientes) {
                    System.out.println(c.getNombre() + " - " + c.getDomicilio() + " - " + c.getNif());
                }
                vista.MostrarClientes(clientes);
                break;
            case 23:
                //  opcion   Mostrar Clientes Stándar
                vista.MostrarClientesStandard();
                break;
            case 24:
                //  opcion   Mostrar Clietes Premium
                vista.MostrarClientesPremium();
                break;
            case 31:
                //  opcion    Añadir pedido
                break;
            case 32:
                //  opcion    Eliminar pedido
                break;
            case 33:
                //  opcion    Mostrar Pedidos pendientes
                vista.MostrarPedidosPendientes();
                break;
            case 34:
                //  opcion    Mostrar Pedidos enviados
                vista.MostrarPedidosEnviados();
                break;
            case 0:
                System.out.println("Fin del programa.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }




    public void ValoresInicio(){

modelo.Cliente cliente1 = new modelo.Cliente("111@kkk.com","name1","dom1","nif1");
modelo.Cliente cliente2 = new modelo.Cliente("222@kkk.com","name2","dom2","nif2");
modelo.Cliente cliente3 = new modelo.Cliente("3333@kkk.com","name3","dom3","nif3");

modelo.Articulo articulo1 = new modelo.Articulo("art1 ","des1 ",111,11,1111);
modelo.Articulo articulo2 = new modelo.Articulo("art2 ","des2 ",222,22,2222);
modelo.Articulo articulo3 = new modelo.Articulo("art3 ","des3 ",333,33,3333);

modelo.Pedido pedido1 = new modelo.Pedido(1,cliente1,articulo1,1,2007-12-01, EstadoPedido.Pendiente);
modelo.Pedido pedido2 = new modelo.Pedido(2,cliente2,articulo2,2,2007-12-02,EstadoPedido.Pendiente);
modelo.Pedido pedido3 = new modelo.Pedido(3,cliente3,articulo3,3,2007-12-03,EstadoPedido.Finalizado);

        tienda.añadirArticulo(articulo1);
        tienda.añadirArticulo(articulo2);
        tienda.añadirArticulo(articulo3);

        tienda.añadirCliente(cliente1);
        tienda.añadirCliente(cliente2);
        tienda.añadirCliente(cliente3);

        tienda.añadirPedido(pedido1);
        tienda.añadirPedido(pedido2);
        tienda.añadirPedido(pedido3);
    }



}