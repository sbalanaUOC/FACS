package Controlador;


import java.util.ArrayList;

import modelo.EstadoPedido;
import modelo.Modelo;
import vista.Vista;
import modelo.OnlineStore;


OnlineStore tienda= new OnlineStore();

public class Controlador {

    private Modelo modelo;
    private Vista vista;




    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }



    public Modelo getModelo() {return modelo;}
    public void setModelo(Modelo modelo) {this.modelo = modelo;}
    public Vista getVista() {return vista;}
    public void setVista(Vista vista) {this.vista = vista;}









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
                tienda.añadirArticulo(vista.InfoArticulo());
                break;

            case 12:
                  //  opcion Mostrar articulos
                ArrayList<modelo.Articulo> articulos = tienda.getListadoArticulos();
                vista.MostrarArticulos(articulos);
                break;

            case 21:
                //  opcion Añadir cliente
                //vista.InfoCliente();




                //tienda.añadirCliente(vista.InfoCliente());
                break;

            case 22:
                //  opcion   Mostrar clientes
                   ArrayList<modelo.Cliente> clientes = tienda.getListadoClientes();
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

    //public void altaCliente(int tipo, String email, String nombre, String domicilio, String nif) {
    //    Cliente cliente;

    //    if(tipo == 1) {
    //        cliente = new ClienteEstandar(email, nombre, domicilio, nif);
    //    } else {
    //        cliente = new ClientePremium(email, nombre, domicilio, nif);
    //    }
    //    tienda.añadirCliente(cliente);
    //}


    public void ValoresInicio(){

        modelo.ClienteEstandar cliente1 = new modelo.ClienteEstandar("111@kkk.com","name1","dom1","nif1");
        modelo.ClienteEstandar cliente2 = new modelo.ClienteEstandar("222@kkk.com","name2","dom2","nif2");
        modelo.ClienteEstandar cliente3 = new modelo.ClienteEstandar("3333@kkk.com","name3","dom3","nif3");
        modelo.ClientePremium cliente4 = new modelo.ClientePremium("4444@kkk.com","name4","dom4","nif4");
        modelo.ClientePremium cliente5 = new modelo.ClientePremium("5555@kkk.com","name5","dom5","nif5");
        modelo.ClientePremium cliente6 = new modelo.ClientePremium("6666@kkk.com","name6","dom6","nif6");


        modelo.Articulo articulo1 = new modelo.Articulo("art1 ","des1 ",111,11,1111);
        modelo.Articulo articulo2 = new modelo.Articulo("art2 ","des2 ",222,22,2222);
        modelo.Articulo articulo3 = new modelo.Articulo("art3 ","des3 ",333,33,3333);

        modelo.Pedido pedido1 = new modelo.Pedido(1,cliente1,articulo1,1,2007-12-01,EstadoPedido.Pendiente);
        modelo.Pedido pedido2 = new modelo.Pedido(2,cliente2,articulo2,2,2007-12-02,EstadoPedido.Pendiente);
        modelo.Pedido pedido3 = new modelo.Pedido(3,cliente3,articulo3,3,2007-12-03, EstadoPedido.Finalizado);

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

void main() {
}