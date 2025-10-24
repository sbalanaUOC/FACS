package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

import modelo.*;
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
                tienda.añadirArticulo(vista.InfoArticulo());

                break;
            case 12:
                  //  opcion Mostrar articulos
                ArrayList<modelo.Articulo> articulos = tienda.getListadoArticulos();
                vista.MostrarArticulos(articulos);

                break;
            case 21:
                //  opcion Añadir cliente
                String[] usuarios = Vista.InfoCliente();

                if (usuarios[4].equals("1")) {
                    System.out.println("El usuario eligió Standard");
                    ClienteEstandar cs=new ClienteEstandar(usuarios[0],usuarios[1],usuarios[2],usuarios[3]);
                    tienda.añadirClienteEstandar(cs);

                } else if (usuarios[4].equals("2")) {
                    System.out.println("El usuario eligió Premium");
                    ClientePremium cp=new ClientePremium(usuarios[0],usuarios[1],usuarios[2],usuarios[3]);
                    tienda.añadirClientePremium(cp);
                } else {
                    //
                }
                break;

            case 22:
                //  opcion   Mostrar clientes
                ArrayList<modelo.ClienteEstandar> clientes = tienda.getListadoClienteEstandar();
                vista.MostrarClientesStandard(clientes);
                ArrayList<modelo.ClientePremium> clientes2 = tienda.getListadoClientePremium();
                vista.MostrarClientesPremium(clientes2);

                break;
            case 23:
                //  opcion   Mostrar Clientes Stándar
                ArrayList<modelo.ClienteEstandar> clientessd = tienda.getListadoClienteEstandar();
                vista.MostrarClientesStandard(clientessd);
                break;
            case 24:
                //  opcion   Mostrar Clietes Premium
                //  opcion   Mostrar Clientes Stándar
                ArrayList<modelo.ClientePremium> clientespm = tienda.getListadoClientePremium();
                vista.MostrarClientesPremium(clientespm);
                break;
            case 31:
                //  opcion    Añadir pedido
                break;
            case 32:
                //  opcion    Eliminar pedido
                break;
            case 33:
                //  opcion    Mostrar Pedidos pendientes
                vista.MostrarPedidosPendientes(tienda.getListadoPedidosPendientes());
                break;
            case 34:
                //  opcion    Mostrar Pedidos enviados

                vista.MostrarPedidosEnviados(tienda.getListadoPedidosFinalizados());
            case 35:
                //  opcion SECRETA    Mostrar Pedidos
                vista.MostrarPedidosEnviados(tienda.getListadoPedidos());


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


modelo.ClienteEstandar cliente1 = new modelo.ClienteEstandar("111@kkk.com","name1","dom1","nif1");
modelo.ClienteEstandar cliente2 = new modelo.ClienteEstandar("222@kkk.com","name2","dom2","nif2");
modelo.ClientePremium cliente3 = new modelo.ClientePremium("3333@kkk.com","name3","dom3","nif3");
modelo.ClientePremium cliente4 = new modelo.ClientePremium("4444@kkk.com","name4","dom4","nif4");



modelo.Articulo articulo1 = new modelo.Articulo("art1 ","des1 ",111,11,1111);
modelo.Articulo articulo2 = new modelo.Articulo("art2 ","des2 ",222,22,2222);
modelo.Articulo articulo3 = new modelo.Articulo("art3 ","des3 ",333,33,3333);

modelo.Pedido pedido1 = new modelo.Pedido(1,cliente1,articulo1,1,LocalDateTime.now(), EstadoPedido.Pendiente);
modelo.Pedido pedido2 = new modelo.Pedido(2,cliente2,articulo2,2,LocalDateTime.now(),EstadoPedido.Pendiente);
modelo.Pedido pedido3 = new modelo.Pedido(3,cliente3,articulo3,3,LocalDateTime.now(),EstadoPedido.Finalizado);

        tienda.añadirArticulo(articulo1);
        tienda.añadirArticulo(articulo2);
        tienda.añadirArticulo(articulo3);

        tienda.añadirClienteEstandar(cliente1);
        tienda.añadirClienteEstandar(cliente2);
        tienda.añadirClientePremium(cliente3);
        tienda.añadirClientePremium(cliente4);


        tienda.añadirPedido(pedido1);
        tienda.añadirPedido(pedido2);
        tienda.añadirPedido(pedido3);
    }



}