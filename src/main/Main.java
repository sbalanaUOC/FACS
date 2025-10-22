import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;

void main() {

Modelo modelo = new Modelo();
Vista vista = new Vista();

Controlador controlador = new Controlador(modelo, vista);

    controlador.iniciarPrograma();


}

