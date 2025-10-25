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
            //****************************************
            case 11:
                //  opcion Añadir artículo
                addArticulo();
                break;
            case 12:
                //  opcion Mostrar articulos
                MostrarArticulos();
                break;
            //****************************************
            case 21:
                //  opcion Añadir cliente
                addClientes();
                break;

            case 22:
                //  opcion   Mostrar clientes
                MostrarCLientes();
                break;

            case 23:
                //  opcion   Mostrar Clientes Stándar
                MostrarCLientesSTD();
                break;
            case 24:
                //  opcion   Mostrar Clietes Premium
                MostrarCLientesPRM();
                break;
            //****************************************
            case 31:
                //  opcion    Añadir pedido
                MostrarArticulos();
                MostrarCLientes();

                AddPedido();
                break;

            case 32:
                //  opcion  Eliminar pedido
                  DeletePedido();
                break;
            case 33:
                //  opcion    Mostrar Pedidos pendientes
                MostrarPendientes();
               break;
            case 34:
                //  opcion    Mostrar Pedidos enviados
                MostrarFinalizados();
                break;
            case 35:
                //  opcion SECRETA    Mostrar Pedidos
                MostrarTodosPedidos();
                break;
            case 0:
                System.out.println("Fin del programa.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }
    //*************************************************************************************************
//  funciones de Articulo

    //  opcion 11  Añadir artículo
    public void addArticulo() {
        tienda.añadirArticulo(vista.InfoArticulo());
    }

    //  opcion 12  Mostrar artículo
    public void MostrarArticulos() {
        ArrayList<modelo.Articulo> articulos = tienda.getListadoArticulos();
        vista.MostrarArticulos(articulos);
    }
//*************************************************************************************************
//  funciones de CLientes

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

    //  opcion 22  Mostrar Clientes
    public void MostrarCLientes() {
        ArrayList<modelo.ClienteEstandar> clientessd = tienda.getListadoClienteEstandar();
        vista.MostrarClientesStandard(clientessd);
        ArrayList<modelo.ClientePremium> clientespr = tienda.getListadoClientePremium();
        vista.MostrarClientesPremium(clientespr);
    }

    //  opcion 23  Mostrar Clientes Standard
    public void MostrarCLientesSTD() {
        ArrayList<modelo.ClienteEstandar> clientes = tienda.getListadoClienteEstandar();
        vista.MostrarClientesStandard(clientes);
    }

    //  opcion 24  Mostrar Clientes PremiumStandard
    public void MostrarCLientesPRM() {
        ArrayList<modelo.ClientePremium> clientespm = tienda.getListadoClientePremium();
        vista.MostrarClientesPremium(clientespm);
    }

//*************************************************************************************************
//  funciones de Pedidos

    //  opcion 31  Insercion Pedidos
    public void AddPedido() {

        //  opcion    Añadir pedido
        Cliente cliente_aux=new Cliente("0","0","0","0");
        Articulo articulo_aux=new Articulo("0","0",0,0,0);
        //Cliente cliente_aux = null;
        //Articulo articulo_aux = null;
        boolean clienteencontrado=false;
        boolean productoencontrado=false;

        String[] resultado = vista.InfoPedido();

        for (Cliente c : tienda.getListadoClienteEstandar()) {
            System.out.println("comparando..." + resultado[0] + "  con  "+c.getNombre());
            if (c.getNombre().equals(resultado[0])) {
                cliente_aux.setEmail(c.getEmail());
                cliente_aux.setNombre(c.getNombre());
                cliente_aux.setDomicilio(c.getDomicilio());
                cliente_aux.setNif(c.getNif());
                clienteencontrado=true;
                break;
            }
        }
        for (Cliente c : tienda.getListadoClientePremium()) {
            System.out.println("comparando..." + resultado[0] + "  con  "+c.getNombre());
            if (c.getNombre().equals(resultado[0])) {
                cliente_aux.setEmail(c.getEmail());
                cliente_aux.setNombre(c.getNombre());
                cliente_aux.setDomicilio(c.getDomicilio());
                cliente_aux.setNif(c.getNif());
                clienteencontrado=true;
                break;
            }
        }
        for (Articulo a : tienda.getListadoArticulos()) {
            System.out.println("comparando..." + resultado[1] + "  con  "+a.getCodigo());
            if (a.getCodigo().equals(resultado[1])) {
                articulo_aux.setCodigo(a.getCodigo());
                articulo_aux.setDescripcion(a.getDescripcion());
                articulo_aux.setPrecioVenta(a.getPrecioVenta());
                articulo_aux.setGastosEnvio(a.getGastosEnvio());
                articulo_aux.setTiempoPreparacion(a.getTiempoPreparacion());
                productoencontrado=true;
                break;
            }
        }

        if (productoencontrado==true) {
            if (clienteencontrado == false){
                addClientes();
            }
           // BuscarCliente(resultado[0]);
            Pedido pd = new Pedido(BuscarCliente(resultado[0]), articulo_aux, Integer.parseInt(resultado[2]));
            tienda.añadirPedido(pd);
        }else{
            System.out.println("Error el producto no existe. inicie el Proceso de Insercion");

        }


    }


    //  opcion 32  Eliminar Pedidos
    public void DeletePedido(){

        String codigo = vista.delPedido();
        for (Pedido p : tienda.getListadoPedidosPendientes()) {
            System.out.println("comparando..." + codigo + "  con  " + p.getNum_pedido());
            if (p.getNum_pedido() == Integer.parseInt(codigo)) {
                tienda.eliminarPedido(p);
                break;
            }
        }
    }


    //  opcion 33   Mostrar Pedidos pendientes
    public void MostrarPendientes(){
        vista.MostrarPedidosPendientes(tienda.getListadoPedidosPendientes());
    }

    //  opcion 34   Mostrar Pedidos pendientes
    public void MostrarFinalizados(){
        vista.MostrarPedidosFinalizados(tienda.getListadoPedidosFinalizados());
    }

    //  opcion 35   Mostrar Todos Pedidos (modo admin)
    public void MostrarTodosPedidos() {
        MostrarPendientes();
        MostrarFinalizados();
    }

    //********************************************************************************

    public Cliente BuscarCliente( String name){
        Cliente cliente_aux=new Cliente("0","0","0","0");
        //
        for (Cliente c : tienda.getListadoClienteEstandar()) {
            System.out.println("2a vuelta..." + name + "  con  "+c.getNombre());
            if (c.getNombre().equals(name)) {
                cliente_aux.setEmail(c.getEmail());
                cliente_aux.setNombre(c.getNombre());
                cliente_aux.setDomicilio(c.getDomicilio());
                cliente_aux.setNif(c.getNif());
            }
        }

        for (Cliente c : tienda.getListadoClientePremium()) {
            System.out.println("2a vuelta..." + name + "  con  "+c.getNombre());
            if (c.getNombre().equals(name)) {
                cliente_aux.setEmail(c.getEmail());
                cliente_aux.setNombre(c.getNombre());
                cliente_aux.setDomicilio(c.getDomicilio());
                cliente_aux.setNif(c.getNif());
            }
        }

        return cliente_aux;
    }


    //**************************************************************************
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