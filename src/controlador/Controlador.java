package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

import modelo.*;
import vista.Vista;



public class Controlador {

    private Modelo modelo;
    private Vista vista;

    OnlineStore tienda = new OnlineStore();


    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }


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
                addArticulo();
                break;
            case 12:
                //  opcion Mostrar articulos
                MostrarArticulos();
                break;
            case 21:
                //  opcion Añadir cliente

                addClientes();

                break;

            case 22:
                //  opcion   Mostrar clientes
                ArrayList<modelo.ClienteEstandar> clientessd = tienda.getListadoClienteEstandar();
                vista.MostrarClientesStandard(clientessd);
                ArrayList<modelo.ClientePremium> clientespr = tienda.getListadoClientePremium();
                vista.MostrarClientesPremium(clientespr);

                break;
            case 23:
                //  opcion   Mostrar Clientes Stándar
                ArrayList<modelo.ClienteEstandar> clientes = tienda.getListadoClienteEstandar();
                vista.MostrarClientesStandard(clientes);
                break;
            case 24:
                //  opcion   Mostrar Clietes Premium
                //  opcion   Mostrar Clientes Stándar
                ArrayList<modelo.ClientePremium> clientespm = tienda.getListadoClientePremium();
                vista.MostrarClientesPremium(clientespm);
                break;
            case 31:
                //  opcion    Añadir pedido
                //Cliente cliente_aux=new Cliente("0","0","0","0");
                //Articulo articulo_aux=new Articulo("0","0",0,0,0);
                Cliente cliente_aux = null;
                Articulo articulo_aux = null;

                String[] resultado = vista.InfoPedido();


                for (Cliente c : tienda.getListadoClientes()) {
                    if (c.getNombre().equals(resultado[0])) {
                        cliente_aux = c;
                        //System.out.println("cliente encontrado: " + c.getNombre());
                        break;  // opcional: salir si solo quieres el primero que coincide
                    }
                }

                for (Articulo a : tienda.getListadoArticulos()) {
                    if (a.getCodigo().equals(resultado[1])) {
                        articulo_aux = a;
                        //System.out.println("articulo encontrado: " + c.getNombre());
                        break;  // opcional: salir si solo quieres el primero que coincide
                    }
                }

                Pedido pd = new Pedido(cliente_aux, articulo_aux, Integer.parseInt(resultado[2]));

                tienda.añadirPedido(pd);

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

    //  opcion 11  Añadir artículo
    public void addArticulo() {
        tienda.añadirArticulo(vista.InfoArticulo());
    }

    //  opcion 12  Mostrar artículo
    public void MostrarArticulos() {
        ArrayList<modelo.Articulo> articulos = tienda.getListadoArticulos();
        vista.MostrarArticulos(articulos);
    }

    //  opcion 21 Añadir cliente
    public void addClientes() {
        String[] usuarios = Vista.InfoCliente();

           if (usuarios[4].equals("1")) {
                System.out.println("El usuario eligió Standard");
                ClienteEstandar cs = new ClienteEstandar(usuarios[0], usuarios[1], usuarios[2], usuarios[3]);
                tienda.añadirClienteEstandar(cs);

            } else if (usuarios[4].equals("2")) {
                System.out.println("El usuario eligió Premium");
                ClientePremium cp = new ClientePremium(usuarios[0], usuarios[1], usuarios[2], usuarios[3]);
                tienda.añadirClientePremium(cp);
            } else {
               //
           }
    }






    public void ValoresInicio(){

        modelo.ClienteEstandar cliente1 = new modelo.ClienteEstandar("111@kkk.com","name1","dom1","nif1");
        modelo.ClienteEstandar cliente2 = new modelo.ClienteEstandar("222@kkk.com","name2","dom2","nif2");
        modelo.ClientePremium cliente3 = new modelo.ClientePremium("3333@kkk.com","name3","dom3","nif3");
        modelo.ClientePremium cliente4 = new modelo.ClientePremium("4444@kkk.com","name4","dom4","nif4");

        modelo.Articulo articulo1 = new modelo.Articulo("art1","des1",111,11,1111);
        modelo.Articulo articulo2 = new modelo.Articulo("art2","des2",222,22,2222);
        modelo.Articulo articulo3 = new modelo.Articulo("art3","des3",333,33,3333);

        modelo.Pedido pedido1 = new modelo.Pedido(cliente1,articulo1,1,LocalDateTime.now(), EstadoPedido.Pendiente);
        modelo.Pedido pedido2 = new modelo.Pedido(cliente2,articulo2,2,LocalDateTime.now(),EstadoPedido.Pendiente);
        modelo.Pedido pedido3 = new modelo.Pedido(cliente3,articulo3,3,LocalDateTime.now(),EstadoPedido.Finalizado);
        modelo.Pedido pedido4 = new modelo.Pedido(cliente1,articulo1,1);
        modelo.Pedido pedido5 = new modelo.Pedido(cliente2,articulo2,2);
        modelo.Pedido pedido6 = new modelo.Pedido(cliente3,articulo3,3);

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
        tienda.añadirPedido(pedido4);
        tienda.añadirPedido(pedido5);
        tienda.añadirPedido(pedido6);
    }



}