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

}
