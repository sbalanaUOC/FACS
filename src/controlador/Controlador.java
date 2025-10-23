package controlador;

import modelo.Articulo;
import modelo.Modelo;
import vista.Vista;

public class Controlador {

    private Modelo modelo;
    private Vista vista;


    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
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
            case 11:
                vista.InfoArticulo();
                break;
            case 21:
                vista.InfoCliente();
                break;
            case 31:
                vista.InfoPedido();
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