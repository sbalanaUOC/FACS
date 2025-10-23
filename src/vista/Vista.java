package vista;

import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;



public class Vista {

    private Scanner sc;
    Scanner teclado = new Scanner(System.in);

    public Vista() {
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n===== MENÚ PRINCIPAL ONLINE STORE =====");
        System.out.println("\n------------------------");
        System.out.println("\n--- GESTIÓN DE ARTÍCULOS ---");
        System.out.println("11. Añadir artículo");
        System.out.println("12. Mostrar artículos");
        System.out.println("\n------------------------");
        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
        System.out.println("21. Añadir cliente");
        System.out.println("22. Mostrar clientes");
        System.out.println("23. Mostrar Clientes Stándar");
        System.out.println("24. Mostrar Clietes Premium");
        System.out.println("\n------------------------");
        System.out.println("\n--- GESTIÓN DE PEDIDOS ---");
        System.out.println("31. Añadir pedido");
        System.out.println("32. Eliminar pedido");
        System.out.println("33. Mostrar Pedidos pendientes");
        System.out.println("34. Mostrar Pedidos enviados");
        System.out.println("\n------------------------");
        System.out.println("\n------------------------");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }


    //opcion 11
    public Articulo InfoArticulo(){
        Articulo articulo = new Articulo("","",0,0,0);
        System.out.println("\nBienvenido al Menú de Añadir Articulo");
        System.out.print("Ingrese el Codigo de la tienda: ");
        articulo.setCodigo(teclado.nextLine());
        System.out.print("Ingrese Descripcion del producto: ");
        articulo.setDescripcion(teclado.nextLine());
        System.out.print("Ingrese Precio de Venta: ");
        articulo.setPrecioVenta(Float.parseFloat(teclado.nextLine()));
        System.out.print("Ingrese Gastos de envio: ");
        articulo.setGastosEnvio(Float.parseFloat(teclado.nextLine()));
        System.out.print("Ingrese Tiempo de preparacion: ");
        articulo.setTiempoPreparacion(Integer.parseInt(teclado.nextLine()));
        return articulo;
    }


    //  menu 12
    public void MostrarArticulos(ArrayList<Articulo> articulos){
        System.out.println("\n------------------------");
        System.out.println("12. Mostrar artículos");
        System.out.println("\n------------------------");
        for (Articulo a : articulos) {
            System.out.println(a.getCodigo() + " - " + a.getDescripcion() + " - " + a.getPrecioVenta()+ " - " + a.getGastosEnvio()+ " - " + a.getTiempoPreparacion());
        }
    }


    // menu 21
    public void InfoCliente() {
        boolean agregarMasClientes = true;
        while (agregarMasClientes) {
            System.out.println("\nBienvenido al Menú de Añadir Cliente");
            System.out.print("Ingrese el email del cliente: ");
            String email = teclado.nextLine();
            System.out.print("Ingrese Nombre del cliente: ");
            String nombre = teclado.nextLine();
            System.out.print("Ingrese Domicilio: ");
            String domicilio = teclado.nextLine();
            System.out.print("Ingrese Nif del cliente: ");
            String nif = teclado.nextLine();
            modelo.Cliente cliente = new modelo.Cliente(email, nombre, domicilio, nif);
            OnlineStore.añadirCliente(cliente);
            boolean salir = false;
            char opcion;
            do {
                System.out.println("1. Estandar");
                System.out.println("2. Premium");
                System.out.println("0. Cancelar");
                opcion = OpcionMenu();
                switch (opcion) {
                    case '1':
                        modelo.ClienteEstandar estandar = new modelo.ClienteEstandar(email, nombre, domicilio, nif);
                        System.out.print("Cliente estandar registrado.");
                        OnlineStore.añadirClienteEstandar(estandar);
                        salir = true;
                        break;
                    case '2':
                        modelo.ClientePremium premium = new modelo.ClientePremium(email, nombre, domicilio, nif, 30, 0.2f);
                        System.out.print("Cliente premium registrado.");
                        OnlineStore.añadirClientePremium(premium);
                        salir = true;
                        break;
                    case '0':
                        salir = true;
                }
            } while (!salir);
            System.out.print("\n¿Desea añadir otro cliente? (Si/No): ");
            String respuesta = teclado.nextLine();
            if (!respuesta.equalsIgnoreCase("Si")) {
                agregarMasClientes = false;
            }
        }
    }

    // menu 22
    public void MostrarClientes(ArrayList<Cliente> clientes){
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\n------------------------");
        System.out.println("22. Mostrar clientes");
        System.out.println("\n------------------------");
        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " - " + c.getDomicilio() + " - " + c.getNif());
        }
    }

    // menu 23
    public void MostrarClientesStandard(ArrayList<ClienteEstandar> estandar){
        if (estandar.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\n------------------------");
        System.out.println("23. Mostrar Clientes Stándar");
        System.out.println("\n------------------------");
        for (ClienteEstandar cS : estandar) {
            System.out.println(cS.getNombre() + " - " + cS.getDomicilio() + " - " + cS.getNif());
        }
    }

    // menu 24
    public void MostrarClientesPremium(ArrayList<ClientePremium> premium) {
        if (premium.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\n------------------------");
        System.out.println("24. Mostrar Clientes Premium");
        System.out.println("\n------------------------");
        for (ClientePremium cP : premium) {
            System.out.println(cP.getNombre() + " - " + cP.getDomicilio() + " - " + cP.getNif());
        }
    }

    // menu 31
    public void InfoPedido(){
    }

    // menu 33
    public void MostrarPedidosPendientes(){
        System.out.println("\n------------------------");
        System.out.println("33. Mostrar Pedidos pendientes");
        System.out.println("\n------------------------");
    }

    // menu 34
    public void MostrarPedidosEnviados(){
        System.out.println("\n------------------------");
        System.out.println("34. Mostrar Pedidos enviados");
        System.out.println("\n------------------------");
    }

    char OpcionMenu() {
        String resp;
        System.out.print("Elige una opción (1,2 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = "";
        }
        return resp.charAt(0);
    }
}