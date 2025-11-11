package DTO;

import DAO.ClienteDAO;
import DAO.Conexion_MySQL;
import modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO_DTO implements ClienteDAO {



    final String insert ="INSERT INTO clientes (email,nombre,domicilio,nif,tipo) VALUES (?,?,?,?,?)";
    final String readall="select * from articulos;";

    @Override
    public int CreateWithIndex(Cliente k) {
        PreparedStatement stat=null;
        int idGenerado=0;

        try {
            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1,k.getEmail());
            stat.setString(2,k.getNombre());
            stat.setString(3,k.getDomicilio());
            stat.setString(4,k.getNif());
            stat.setInt(5,k.getTipo());

            int filasInsercion=stat.executeUpdate();
            //stat.executeUpdate();
            System.out.println("filas insertadas "+ filasInsercion );
            if (filasInsercion > 0) {
                ResultSet claves = stat.getGeneratedKeys();
                if (claves.next()) {
                    idGenerado = claves.getInt(1);
                }
                System.out.println("idgenerado: " +idGenerado );
            }

        } catch (SQLException ex) {

        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                }
            }
        }
        return idGenerado;
    }

    public void Create(Cliente k) {}


    @Override
    public Cliente Read() {
        return null;
    }

    @Override
    public void Update(Cliente k) {}

    @Override
    public void Delete(Cliente k) {}



    @Override
    public ArrayList<Cliente> Read_all() {
        ArrayList<Cliente> clientes = null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs = ps.executeQuery();

            clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente c = new Cliente(
                        //rs.getInt("idcliente"),
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );
                clientes.add(c);
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
        return clientes;
    }


    public ArrayList<Cliente> Read_STD() {
        ArrayList<Cliente> clientes = null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from clientes where tipo=1");
            ResultSet rs = ps.executeQuery();

            clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente c = new Cliente(
                        //rs.getInt("idcliente"),
                        //rs.getInt("idcliente"),
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );
                clientes.add(c);

            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí
        return clientes;
    }



    public ArrayList<Cliente> Read_PRM() {
        ArrayList<Cliente> clientes = null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from clientes where tipo=2");
            ResultSet rs = ps.executeQuery();

            clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente c = new Cliente(
                        //rs.getInt("idcliente"),
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );
                clientes.add(c);

            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí
        return clientes;
    }

    public Cliente Read_ind(int idcliente){
        Cliente cliente=null;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from cliente where idcliente="+idcliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente(
                        //rs.getInt("idcliente"),
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );

            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí


        return cliente;

    }


}
