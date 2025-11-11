package DTO;

import DAO.ArticuloDAO;
import modelo.Articulo;

import DAO.Conexion_MySQL;

import java.sql.*;

import java.util.ArrayList;

public class ArticuloDAO_DTO implements ArticuloDAO {




    final String insert ="INSERT INTO articulos (idcodigo,descripcion,precioventa,gastosenvio,tiempopreparacion) VALUES (?,?,?,?,?)";
    final String readall="select * from articulos;";



    @Override
    public void Create(Articulo k)  {
        PreparedStatement stat=null;

        try {
            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(insert);
            stat.setString(1,k.getCodigo());
            stat.setString(2,k.getDescripcion());
            stat.setFloat(3,k.getPrecioVenta());
            stat.setFloat(4,k.getGastosEnvio());
            stat.setInt(5,k.getTiempoPreparacion());
            stat.executeUpdate();


        } catch (SQLException ex) {

        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {


                }
            }
            ;
        }

    }


    @Override
    public int CreateWithIndex(Articulo K) {
        return 0;
    }

    @Override
    public Articulo Read() {
        return null;
    }

    @Override
    public void Update(Articulo k) {}

    @Override
    public void Delete(Articulo k) {}



    @Override
    public ArrayList<Articulo> Read_all() {
        ArrayList<Articulo> articulos = null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM articulos");
            ResultSet rs = ps.executeQuery();

            articulos = new ArrayList<>();

            while (rs.next()) {
                Articulo a = new Articulo(
                        rs.getString("idcodigo"),
                        rs.getString("descripcion"),
                        rs.getFloat("precioventa"),
                        rs.getFloat("gastosenvio"),
                        rs.getInt("tiempopreparacion")
                );
                articulos.add(a);
                // Mueve el cursor a la siguiente fila, devuelve false si no hay más
                //System.out.println("leo:  " + rs.getString("idcodigo"));
                //System.out.println("leo:  " + rs.getString("descripcion"));
                //System.out.println("leo:  " + rs.getFloat("precioventa"));
                //System.out.println("leo:  " + rs.getFloat("gastosenvio"));
                //System.out.println("leo:  " + rs.getInt("tiempopreparacion"));
            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí


        return articulos;


    }


}
