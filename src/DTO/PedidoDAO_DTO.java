package DTO;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.Conexion_MySQL;
import modelo.Articulo;
import modelo.Cliente;
import modelo.EstadoPedido;
import modelo.Pedido;

import java.sql.*;
import java.time.LocalDateTime;
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

    public ArrayList<Pedido> ReadByEstado(String estado) {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        String sql = "    SELECT p.numeropedido, p.cantidad, p.fecha, p.idestadopedido,\n" +
                     "           c.idcliente, c.email, c.nombre, c.domicilio, c.nif, c.tipo,\n" +
                     "           a.idcodigo, a.descripcion, a.precioventa, a.gastosenvio, a.tiempopreparacion\n" +
                     "    FROM pedidos p\n" +
                     "    JOIN clientes c ON p.idcliente = c.idcliente\n" +
                     "    JOIN articulos a ON p.idcodigoarticulo = a.idcodigo\n" +
                     "    WHERE p.idestadopedido = ?\n" +
                     "    ORDER BY p.numeropedido;\n";

        try (Connection conn = Conexion_MySQL.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("email"),
                        rs.getString("nombre"),
                        rs.getString("domicilio"),
                        rs.getString("nif"),
                        rs.getInt("tipo")
                );
                cliente.setIdCliente(rs.getInt("idcliente"));

                Articulo articulo = new Articulo(
                        rs.getString("idcodigo"),
                        rs.getString("descripcion"),
                        rs.getFloat("precioventa"),
                        rs.getFloat("gastosenvio"),
                        rs.getInt("tiempopreparacion")
                );

                Pedido pedido = new Pedido(cliente, articulo, rs.getInt("cantidad"));
                pedido.setNum_pedido(rs.getInt("numeropedido"));
                pedido.setFecha(LocalDateTime.parse(rs.getString("fecha").replace(" ", "T")));
                pedido.setEstado(EstadoPedido.valueOf(rs.getString("idestadopedido")));

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
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
