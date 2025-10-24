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

        System.out.println("\n------------------------");
        System.out.println("\nBienvenido al Menú de Añadir Articulo");
        System.out.println("\n------------------------");
        System.out.print("Ingrese el Codigo del producto: ");
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
        System.out.println("12. Menu de Mostrar artículos");
        System.out.println("\n------------------------");
        for (Articulo a : articulos) {
            System.out.println(a.getCodigo() + " - " + a.getDescripcion() + " - " + a.getPrecioVenta()+ " - " + a.getGastosEnvio()+ " - " + a.getTiempoPreparacion());
        }
    }


    // menu 21
    public static String[] InfoCliente() {
        Scanner teclado = new Scanner(System.in);
        String[] datos = new String[5]; // array para almacenar los 5 valores

        System.out.println("\n------------------------");
        System.out.println("\nBienvenido al Menú de Añadir Cliente");
        System.out.println("\n------------------------");
        System.out.print("Ingrese el email del cliente: ");
         datos[0]= teclado.nextLine();
        System.out.print("Ingrese Nombre del cliente: ");
         datos[1] = teclado.nextLine();
        System.out.print("Ingrese Domicilio: ");
         datos[2] = teclado.nextLine();
        System.out.print("Ingrese Nif del cliente: ");
         datos[3] = teclado.nextLine();
        System.out.println("¿Como lo quiere dar de alta? (1-Standard, 2-Premium)");
         datos[4] = teclado.nextLine();
        //
        System.out.println("GENIAL!!  ESO ES TODO... El usuario ya se esta dando de alta");

        return datos;
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
    public static String[] InfoPedido() {
        Scanner teclado = new Scanner(System.in);
        String[] datospedido = new String[3]; // array para almacenar los 3 valores

        System.out.println("\n------------------------");
        System.out.println("\nBienvenido al Menú de Añadir Pedido");
        System.out.println("\n------------------------");
        System.out.print("Ingrese el nombre del cliente: ");
        datospedido[0]= teclado.nextLine();
        System.out.print("Ingrese articulo del pedido: ");
        datospedido[1] = teclado.nextLine();
        System.out.print("Ingrese la cantidad: ");
        datospedido[2] = teclado.nextLine();
        //
        System.out.println("...Un momento por favor...");

        return datospedido;
    }




    // menu 32







    // menu 33
    public void MostrarPedidosPendientes(ArrayList<Pedido> pendientes){
        System.out.println("\n------------------------");
        System.out.println("33. Mostrar Pedidos pendientes");
        System.out.println("\n------33------------------");

        for (Pedido p : pendientes) {
            System.out.println(" num: "+p.getNum_pedido() + " / cliente: " + p.getCliente() + " / articulo: " + p.getArticulo()+ " / cantidad: " + p.getCantidad()+ " / fecha: " + p.getFecha()+ " / estado: " + p.getEstado());
            System.out.println(" 33 ");
        }
    }

    // menu 34
    public void MostrarPedidosEnviados(ArrayList<Pedido> finalizados){
        System.out.println("\n------------------------");
        System.out.println("34. Mostrar Pedidos enviados");
        System.out.println("\n------------------------");

        for (Pedido f : finalizados) {
            System.out.println(" num: "+f.getNum_pedido() + " / cliente: " + f.getCliente() + " / articulo: " + f.getArticulo()+ " / cantidad: " + f.getCantidad()+ " / fecha: " + f.getFecha()+ " / estado: " + f.getEstado());
            System.out.println(" 34 ");
        }
    }
//
//    char OpcionMenu() {
//        String resp;
//        System.out.print("Elige una opción (1,2 o 0): ");
//        resp = teclado.nextLine();
//        if (resp.isEmpty()) {
//            resp = "";
//        }
//        return resp.charAt(0);
//
//    }


}