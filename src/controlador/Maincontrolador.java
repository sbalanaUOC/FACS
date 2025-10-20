package controlador;

import modelo.Mainmodelo;
import vista.Mainvista;

public class Maincontrolador {
    private Mainmodelo modelo;
    private Mainvista vista;


    public Maincontrolador(Mainmodelo inmodelo, Mainvista invista) {
        this.modelo = inmodelo;
        this.vista = invista;
    }


    // Métodos que conectan vista y modelo

    public void iniciarPrograma() {
        int opcion;

        do {
            opcion = vista.mostrarMenuPrincipal();
            procesarOpcionPrincipal(opcion);
        } while (opcion != 0);
    }

    private void procesarOpcionPrincipal(int opcion) {
        switch (opcion) {
            case 1:
                vista.mostrarMenuArticulos();
                break;
            case 2:
                vista.mostrarMenuClientes();
                break;
            case 3:
                vista.mostrarMenuPedidos();
                break;
            case 0:
                System.out.println("Fin del programa.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }
}