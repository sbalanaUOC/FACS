package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        // Configuración de la conexión
        String url = "jdbc:mysql://localhost:3306/FACS";
        String usuario = "root";  // Mi usuario MySQL
        String password = "Holas3031";  // La contraseña que he puesto en MySQL

        try {
            // Intentar conectar
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            System.out.println("Perfecto, te has conectado a MySQL!");
            System.out.println("Base de datos: " + conexion.getCatalog());

            // Cerrar conexión
            conexion.close();

        } catch (SQLException e) {
            System.out.println("No te has podido conectar a la base de datos de FACS:");
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
