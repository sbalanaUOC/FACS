package vista;

import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;

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

    public void AñadirClientes() {
        System.out.println("\n------------------------");
        System.out.println("21. Añadir clientes");
        System.out.println("\n------------------------");
        boolean agregarMasClientes = true;
        while (agregarMasClientes) {
            System.out.print("Ingrese el email del cliente: ");
            String email = sc.nextLine();
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el domicilio del cliente: ");
            String domicilio = sc.nextLine();
            System.out.print("Ingrese el nif del cliente: ");
            String nif = sc.nextLine();
            System.out.print("Seleccione el tipo de cliente: \n");
            boolean salir = false;
            char opción;
            do {
                System.out.println("1. Estandar");
                System.out.println("2. Premium");
                System.out.println("0. Cancelar la adición del cliente");
                opción = clienteOpciónMenu21();
                switch (opción) {
                    case '1':
                        ClienteEstandar estandar = new ClienteEstandar (email, nombre, domicilio, nif);
                        c.add(estandar);
                        System.out.print("Cliente premium registrado.");
                        salir = true;
                        break;
                    case '2':
                        System.out.print("Pagar cuota.");
                        int cuota = Integer.parseInt(sc.nextLine());
                        float descuento = Float.parseFloat((String.valueOf(0.2)));
                        ClientePremium premium = new ClientePremium (email, nombre, domicilio, nif,cuota, descuento);
                        c.add(premium);
                        System.out.print("Cliente premium registrado.");
                        salir = true;
                        break;
                    case '0':
                        salir = true;
                }
            } while (!salir);
            System.out.print("\n¿Desea añadir otro cliente? (Si/No): ");
            String respuesta = sc.nextLine();
            if (!respuesta.equalsIgnoreCase("Si")) {
                agregarMasClientes = false;
            }
        }
    }

    public void MostrarClientes(ArrayList<Cliente> clientes){
        System.out.println("\n------------------------");
        System.out.println("22. Mostrar clientes");
        System.out.println("\n------------------------");
        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " - " + c.getDomicilio() + " - " + c.getNif());
        }
    }

    char clienteOpciónMenu21() {
        String resp;
        System.out.print("Elige una opción (1,2 o 0): ");
        resp = sc.nextLine();
        if (resp.isEmpty()) {
            resp = "";
        }
        return resp.charAt(0);
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



