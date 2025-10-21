package vista;

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
        System.out.println("33. Pedidos pendientes");
        System.out.println("34. Pedidos enviados");
        System.out.println("\n------------------------");
        System.out.println("\n------------------------");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }


}



