package DTO;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.Conexion_MySQL;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

import java.sql.*;
import java.util.ArrayList;

public class PedidoDAO_DTO implements PedidoDAO {

    //final String insert ="insert into pedidos (idcliente,idcodigoarticulo,cantidad,fecha,estadopedido) VALUES (5,"art3",4,"date","Pendiente");";
    final String insert = "INSERT INTO pedidos (idcliente,idcodigoarticulo,cantidad,fecha,idestadopedido) VALUES (?,?,?,?,?)";
    final String readall = "SELECT * FROM pedidos";
    final String delete = "DELETE FROM pedidos WHERE numeropedido = ?";




    @Override
    public void Create(Pedido k) {
        try (Connection conn = Conexion_MySQL.getConnection();
             PreparedStatement stat = conn.prepareStatement(insert)) {

            System.out.println("Insertando pedido: " + k);

            stat.setInt(1, k.getCliente().getIdCliente());
            stat.setString(2, k.getArticulo().getCodigo());
            stat.setInt(3, k.getCantidad());
            stat.setString(4, k.getFecha().toString());
            stat.setString(5, k.getEstado().name()); // "Pendiente" o "Finalizado"

            stat.executeUpdate();
            System.out.println("Pedido insertado correctamente.");

        } catch (SQLException ex) {
            System.err.println("Error SQLState: " + ex.getSQLState());
            System.err.println("Código de error: " + ex.getErrorCode());
            System.err.println("Mensaje: " + ex.getMessage());
        }
    }


    @Override
    public int CreateWithIndex(Pedido k) {
       return 0;
    }

    @Override
    public Pedido Read() {
        return null;
    }

    @Override
    public void Update(Pedido k) {
    }

    @Override
    public void Delete(Pedido k) {
        PreparedStatement stat=null;
        System.out.println("borra:  " + k);
        try {

            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(delete);
            stat.setInt(1,k.getNum_pedido());
            stat.executeUpdate();


        } catch (SQLException ex) {

        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public void DeleteWithID(Integer idPedido) {
        PreparedStatement stat=null;
        try {

            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(delete);
            stat.setInt(1,idPedido);
            stat.executeUpdate();


        } catch (SQLException ex) {

        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                }
            }
        }
    }


    @Override
    public ArrayList<Pedido> Read_all() {
        ArrayList<Pedido> pedidos = null;
        Cliente cliente=null;
        Articulo articulo=null;

        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from pedidos");
            ResultSet rs = ps.executeQuery();

            pedidos = new ArrayList<>();

            while (rs.next()) {
                cliente = new Cliente();
                articulo = new Articulo();

                //PEDIDO= cliente  articulo  cantidad  fecha  estado
                Pedido p = new Pedido(

                                   cliente,
                                   articulo,
                                   rs.getInt("cantidad")
                );
                pedidos.add(p);

            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí
        return pedidos;

    }


}
