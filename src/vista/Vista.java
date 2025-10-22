package vista;

import modelo.Cliente;
import modelo.Articulo;


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
    //

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


    //menu 22
    public void MostrarClientes(ArrayList<Cliente> clientes){
        System.out.println("\n------------------------");
        System.out.println("22. Mostrar clientes");
        System.out.println("\n------------------------");
        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " - " + c.getDomicilio() + " - " + c.getNif());
        }
    }

    public void MostrarClientesStandard(){
        System.out.println("\n------------------------");
        System.out.println("23. Mostrar Clientes Stándar");
        System.out.println("\n------------------------");
    }

    public void MostrarClientesPremium() {
        System.out.println("\n------------------------");
        System.out.println("24. Mostrar Clientes Premium");
        System.out.println("\n------------------------");
    }

    public void MostrarPedidosPendientes(){
        System.out.println("\n------------------------");
        System.out.println("33. Mostrar Pedidos pendientes");
        System.out.println("\n------------------------");
    }

    public void MostrarPedidosEnviados(){
        System.out.println("\n------------------------");
        System.out.println("34. Mostrar Pedidos enviados");
        System.out.println("\n------------------------");
    }


}



