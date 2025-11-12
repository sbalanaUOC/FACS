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
            System.out.println("cl in: "+ filasInsercion );
            if (filasInsercion > 0) {
                ResultSet claves = stat.getGeneratedKeys();
                if (claves.next()) {
                    idGenerado = claves.getInt(1);
                }
                System.out.println("cl idgen: " +idGenerado );
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
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (Connection conn = Conexion_MySQL.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM clientes");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );
                c.setIdCliente(rs.getInt("idcliente"));
                clientes.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

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


    @Override
    public Cliente Read_ind(int idcliente) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE idcliente = ?";

        try (Connection conn = Conexion_MySQL.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idcliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );
                cliente.setIdCliente(rs.getInt("idcliente")); // ✅ Asignamos el id real
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }


}
