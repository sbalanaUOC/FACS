package vista;

import java.util.Scanner;



public class Vista {

    private Scanner sc;

    public Vista() {
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n===== MENÚ PRINCIPAL ONLINE STORE =====");
        System.out.println("1. Gestión de Artículos");
        System.out.println("2. Gestión de Clientes");
        System.out.println("3. Gestión de Pedidos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public int mostrarMenuArticulos() {
        System.out.println("\n--- GESTIÓN DE ARTÍCULOS ---");
        System.out.println("11. Añadir artículo");
        System.out.println("12. Mostrar artículos");
        System.out.println("10. Volver");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public int mostrarMenuClientes() {
        System.out.println("\n--- GESTIÓN DE CLIENTES ---");
        System.out.println("21. Añadir cliente");
        System.out.println("22. Mostrar clientes");
        System.out.println("23. Mostrar Clientes Stándar");
        System.out.println("24. Mostrar Clietes Premium");
        System.out.println("20. Volver");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public int mostrarMenuPedidos() {
        System.out.println("\n--- GESTIÓN DE PEDIDOS ---");
        System.out.println("31. Añadir pedido");
        System.out.println("32. Eliminar pedido");
        System.out.println("33. Pedidos pendientes");
        System.out.println("34. Pedidos enviados");
        System.out.println("30. Volver");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
}



