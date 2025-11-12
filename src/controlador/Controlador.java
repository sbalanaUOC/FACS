package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
                //System.out.println("El usuario eligió Standard");
                Cliente cs = new Cliente(usuarios[0], usuarios[1], usuarios[2], usuarios[3],Integer.parseInt(usuarios[4]));
                tienda.añadirCliente(cs);


            } else if (usuarios[4].equals("2")) {
                //System.out.println("El usuario eligió Premium");
                Cliente cp = new Cliente(usuarios[0], usuarios[1], usuarios[2], usuarios[3],Integer.parseInt(usuarios[4]));
                tienda.añadirCliente(cp);
            } else {
               //
           }

    }

    //  opcion 22  Mostrar Clientes
    public void MostrarCLientes() {
       // ArrayList<modelo.ClienteEstandar> clientessd = tienda.getListadoClienteEstandar();
       // vista.MostrarClientesStandard(clientessd);
       // ArrayList<modelo.ClientePremium> clientespr = tienda.getListadoClientePremium();
       // vista.MostrarClientesPremium(clientespr);
        ArrayList<modelo.Cliente> clientes = tienda.getListadoClientes();
        vista.MostrarClientes(clientes);

    }

    //  opcion 23  Mostrar Clientes Standard
    public void MostrarCLientesSTD() {
        ArrayList<modelo.Cliente> clientes = tienda.getListadoClienteEstandar();
        vista.MostrarClientesStandard(clientes);
    }

    //  opcion 24  Mostrar Clientes PremiumStandard
    public void MostrarCLientesPRM() {
        ArrayList<modelo.Cliente> clientespm = tienda.getListadoClientePremium();
        vista.MostrarClientesPremium(clientespm);
    }

//*************************************************************************************************
//  funciones de Pedidos

    //  opcion 31  Insercion Pedidos
    public void AddPedido() {

        String[] resultado = vista.InfoPedido(); // [nombreCliente, codigoArticulo, cantidad]
        boolean clienteEncontrado = false;
        boolean productoEncontrado = false;

        Cliente cliente_aux = null;
        Articulo articulo_aux = null;

        // Buscar cliente en memoria
        for (Cliente c : tienda.getListadoClientes()) {
            if (c.getNombre().equalsIgnoreCase(resultado[0])) {
                cliente_aux = c;
                clienteEncontrado = true;
                break;
            }
        }

        // Buscar artículo en memoria
        for (Articulo a : tienda.getListadoArticulos()) {
            if (a.getCodigo().equalsIgnoreCase(resultado[1])) {
                articulo_aux = a;
                productoEncontrado = true;
                break;
            }
        }

        if (!productoEncontrado) {
            System.out.println("Error: el producto no existe. Inicie el proceso de inserción.");
            return;
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado en memoria, añádelo primero.");
            addClientes();
            return;
        }

        // Buscar cliente real desde la BD por su ID
        DTO.ClienteDAO_DTO clienteDAO = new DTO.ClienteDAO_DTO();
        Cliente clienteBD = clienteDAO.Read_ind(cliente_aux.getIdCliente());

        if (clienteBD == null) {
            System.err.println("El cliente con ID " + cliente_aux.getIdCliente() + " no existe en la base de datos.");
            return;
        }

        System.out.println("Cliente validado en BD: " + clienteBD.getNombre() + " (ID=" + clienteBD.getIdCliente() + ")");

        // Crear pedido con cliente real
        Pedido pedido = new Pedido(clienteBD, articulo_aux, Integer.parseInt(resultado[2]));
        pedido.setEstado(EstadoPedido.Pendiente);
        pedido.setFecha(java.time.LocalDateTime.now());

        // Añadir a tienda en memoria
        tienda.añadirPedido(pedido);

        System.out.println("Pedido insertado correctamente.");
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
        Cliente cliente_aux=new Cliente("0","0","0","0",0);
        //
        for (Cliente c : tienda.getListadoClienteEstandar()) {
            //System.out.println("2a vuelta..." + name + "  con  "+c.getNombre());
            if (c.getNombre().equals(name)) {
                cliente_aux.setEmail(c.getEmail());
                cliente_aux.setNombre(c.getNombre());
                cliente_aux.setDomicilio(c.getDomicilio());
                cliente_aux.setNif(c.getNif());
            }
        }

        for (Cliente c : tienda.getListadoClientePremium()) {
            //System.out.println("2a vuelta..." + name + "  con  "+c.getNombre());
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
    public void ValoresInicio() {
        // Cargar clientes reales desde la BD
        DTO.ClienteDAO_DTO clienteDAO = new DTO.ClienteDAO_DTO();
        ArrayList<modelo.Cliente> clientesBD = clienteDAO.Read_all();

        for (modelo.Cliente c : clientesBD) {
            tienda.añadirCliente(c);
        }

        // Cargar artículos de ejemplo
        modelo.Articulo articulo1 = new modelo.Articulo("art1","des1",111,11,1111);
        modelo.Articulo articulo2 = new modelo.Articulo("art2","des2",222,22,2222);
        modelo.Articulo articulo3 = new modelo.Articulo("art3","des3",333,33,3333);

        tienda.añadirArticulo(articulo1);
        tienda.añadirArticulo(articulo2);
        tienda.añadirArticulo(articulo3);
    }




}