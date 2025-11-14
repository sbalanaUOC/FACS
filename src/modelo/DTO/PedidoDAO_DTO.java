package modelo.DTO;

import modelo.DAO.PedidoDAO;
import modelo.DAO.Conexion_MySQL;
import modelo.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PedidoDAO_DTO implements PedidoDAO {


    final String insert =" insert into pedidos (idcliente,idcodigoarticulo,cantidad,fecha,estadopedido) VALUES (?,?,?,?,?)";
    final String readall="select * from pedidos;";
    final String delete="DELETE FROM pedidos WHERE numeropedido = ?";


//*****************************************************************************************
    @Override
    public void Create(Pedido k) {
        PreparedStatement stat=null;
        int idGenerado=0;
        try {
            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(insert);
            //stat.setInt(1,k.getNum_pedido());
            stat.setInt(1,k.getCliente().getIdCliente());
            stat.setString(2,k.getArticulo().getCodigo());
            stat.setInt(3,k.getCantidad());
            stat.setString(4, String.valueOf(k.getFecha()));
            stat.setString(5, String.valueOf(k.getEstado()));

            stat.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error SQLState: " + ex.getSQLState());
            System.err.println("Código de error: " + ex.getErrorCode());
            System.err.println("Mensaje: " + ex.getMessage());
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
//*****************************************************************************************

    @Override
    public int CreateWithIndex(Pedido k) {return 0;}

    @Override
    public Pedido Read() {return null;}

    @Override
    public void Update(Pedido k) {}


    //*****************************************************************************************
    @Override
    public void Delete(Pedido k) {
        PreparedStatement stat=null;
        //System.out.println("borra:  " + k);
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

    //*****************************************************************************************
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
//*****************************************************************************************







    @Override
    public ArrayList<Pedido> Read_all() {
        ArrayList<Pedido> pedidos = null;
        Cliente cliente=null;
        Articulo articulo=null;

        ArticuloDAO_DTO art_Dao=new ArticuloDAO_DTO();
        ClienteDAO_DTO cli_Dao=new ClienteDAO_DTO();


        try {
            Connection conn = Conexion_MySQL.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from pedidos");
            ResultSet rs = ps.executeQuery();

            pedidos = new ArrayList<>();

            while (rs.next()) {

               int numeropedido= rs.getInt("numeropedido");
               int idcliente=rs.getInt("idcliente");
               String idcodigoarticulo= rs.getString("idcodigoarticulo");
               int  cantidad= rs.getInt("cantidad");
               String fecha= rs.getString("fecha");
               String estadopedido= rs.getString("estadopedido");

               // Obtener los objetos completos
                System.out.println("pedido:  "
                        + " / "+numeropedido
                        + " / "+idcliente
                        + " / "+idcodigoarticulo
                        + " / "+cantidad
                        + " / "+fecha
                        + " / "+estadopedido





                );
                Cliente cli = cli_Dao.Read_id(idcliente);
                Articulo art = art_Dao.Read_id(idcodigoarticulo);
                System.out.println("clie:  " + cli);
                System.out.println("arti:  " + art);

            }

        } catch (SQLException e) {
            // Manejar excepción
        }
// La conexión se cierra automáticamente aquí
        return pedidos;

    }













    public ArrayList<Pedido> ReadTable() {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        //String sql = "SELECT p.numeropedido, p.cantidad, p.fecha, p.estadopedido, c.idcliente, c.email, c.nombre, c.domicilio, c.nif, c.tipo,a.idcodigo, a.descripcion, a.precioventa, a.gastosenvio, a.tiempopreparacion FROM pedidos p JOIN clientes c ON p.idcliente = c.idcliente JOIN articulos a ON p.idcodigoarticulo = a.idcodigo WHERE p.estadopedido = "+ estado +" ORDER BY p.numeropedido;";
        String sql = "SELECT p.numeropedido, p.cantidad, p.fecha, p.estadopedido, " +
                     "c.idcliente, c.email, c.nombre, c.domicilio, c.nif, c.tipo," +
                     "a.idcodigo, a.descripcion, a.precioventa, a.gastosenvio, a.tiempopreparacion " +
                     "FROM pedidos p JOIN clientes c ON p.idcliente = c.idcliente JOIN articulos a ON p.idcodigoarticulo = a.idcodigo  ORDER BY p.numeropedido;";




        try (Connection conn = Conexion_MySQL.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //ps.setString(1, estado);
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
                pedido.setEstado(EstadoPedido.valueOf(rs.getString("estadopedido")));

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }







}
