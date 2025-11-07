
import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

void main() {

Modelo modelo = new Modelo();
Vista vista = new Vista();
Controlador controlador = new Controlador(modelo, vista);
    controlador.iniciarPrograma();

//if (conexion()) {
//    ;
//    //System.out.println("Conexion establecida.");
//    controlador.iniciarPrograma();
//     }else {
//            System.out.println("Error de conexion. Revise conectividad");
//
//
//           }


}


public static boolean conexion() {

    try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/facs", "root", "1234")) {
        //System.out.println("Conexion establecida.");
        String db= c.getMetaData().getDatabaseProductName();
        String ver= c.getMetaData().getDatabaseProductVersion();
        System.out.println("Conexion establecida en  "+ db +" con version" + ver );
        return(true);
    } catch (SQLException ex) {
        Logger.getLogger(com.sun.tools.javac.Main.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Error de Conexion.");
        return(false);
    }

}