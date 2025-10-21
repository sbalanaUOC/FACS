package vista;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.Scanner;



public class Vista {

    private Scanner sc;

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


    public void MostrarArticulos(){
        System.out.println("\n------------------------");
        System.out.println("12. Mostrar artículos");
        System.out.println("\n------------------------");
    }

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



