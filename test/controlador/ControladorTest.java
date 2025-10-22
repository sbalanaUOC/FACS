package controlador;

import modelo.Modelo;
import org.junit.jupiter.api.Test;
import vista.Vista;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    @Test
    void test1() {

        Modelo modeloTest = new Modelo();
        Vista vistaTest = new Vista();

        Controlador controladorTest = new Controlador(modeloTest, vistaTest);
        assertAll(
                () -> assertEquals("", ""),
                () -> assertEquals("","")
        );
    }

}