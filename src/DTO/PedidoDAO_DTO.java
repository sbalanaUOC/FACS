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
    final String insert =" insert into pedidos (numeropedido,idcliente,idcodigoarticulo,cantidad,fecha,estadopedido) VALUES (?,?,?,?,?,?)";
    final String readall="select * from pedidos;";
    final String delete="DELETE FROM pedidos WHERE numeropedido = ?";



    @Override
    public void Create(Pedido k) {
        PreparedStatement stat=null;
        int idGenerado=0;
        try {
            System.out.println("pedido "+ k );
            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(insert);
            stat.setInt(1,k.getNum_pedido());
            stat.setInt(2,k.getCliente().getIdCliente());
            stat.setString(3,k.getArticulo().getCodigo());
            stat.setInt(4,k.getCantidad());
            stat.setString(5, String.valueOf(k.getFecha()));
            stat.setString(6, String.valueOf(k.getEstado()));

            //System.out.println("info: "+"/ "+ k.getNum_pedido()
            //        +"/ "+ k.getCliente().getIdCliente()
            //        +"/ "+ k.getArticulo().getCodigo()
            //        +"/ "+ k.getCantidad()
            //        +"/ "+ String.valueOf(k.getFecha())
            //        +"/ "+ String.valueOf(k.getEstado())
            //);


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
            ;
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
