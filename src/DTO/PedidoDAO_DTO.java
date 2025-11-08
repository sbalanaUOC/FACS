package DTO;

import DAO.Conexion_MySQL;
import DAO.PedidoDAO;
import modelo.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO_DTO implements PedidoDAO {


    final String insert ="insert into pedidos (idcliente,idcodigoarticulo,cantidad,fecha,idestadopedido) VALUES (?,?,?,?,?)";
    final String readall="select * from pedidos;";




    @Override
    public void Create(Pedido k) {
        PreparedStatement stat=null;

        try {
            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(insert);
         //   stat.setInt(1,k.getCliente().getNombre());
         //   stat.setString(2,k.getArticulo());
         //   stat.setInt(3,k.getCantidad());
         //   stat.setDate(4,k.getFecha());
         //   stat.setString(5,k.getEstado());
         //   stat.executeUpdate();
         //  System.out.println("leo:  " + insert);
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
    public Pedido Read() {
        return null;
    }

    @Override
    public void Update(Pedido k) {

    }

    @Override
    public void Delete(Pedido k) {

    }

    @Override
    public ArrayList<Pedido> Read_all() {

        ArrayList<Pedido> pedidos = null;
        return pedidos;

    }
}
