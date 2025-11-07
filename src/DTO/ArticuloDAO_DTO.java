package DTO;

import DAO.ArticuloDAO;
import modelo.Articulo;

import DAO.Conexion_MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO_DTO implements ArticuloDAO {




    final String insert ="INSERT INTO articulos (idcodigo,descripcion,precioventa,gastosenvio,tiempopreparacion) VALUES (?,?,?,?,?);";
    final String readall="select * from articulos;";

   // private Connection conn;

   // public ArticuloDAO_DTO(Connection conn){
   //     this.conn=conn;
   // }

    @Override
    public void Create(Articulo k) {
        PreparedStatement stat=null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            stat= conn.prepareStatement(insert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            if (stat!= null){
                try{
                    stat.close();
                }catch (SQLException ex){

                }
            };
        }

    }

    @Override
    public Articulo Read() {
        return null;
    }

    @Override
    public void Update(Articulo k) {

    }

    @Override
    public void Delete(Articulo k) {

    }

    @Override
    public ArrayList<Articulo> Read_all() {
        ArrayList<Articulo> articulos = null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM articulos");
            ResultSet rs = ps.executeQuery();

            articulos = new ArrayList<>();

            while (rs.next()) { // Mueve el cursor a la siguiente fila, devuelve false si no hay más
                System.out.println("leo:  " + rs.getString("idcodigo"));
                System.out.println("leo:  " + rs.getString("descripcion"));
                System.out.println("leo:  " + rs.getFloat("precioventa"));
                System.out.println("leo:  " + rs.getFloat("gastosenvio"));
                System.out.println("leo:  " + rs.getInt("tiempopreparacion"));

            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí


        return articulos;


    }
}
