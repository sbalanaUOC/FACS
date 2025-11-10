package DTO;

import DAO.PedidoDAO;
import DAO.Conexion_MySQL;
import modelo.Pedido;

import java.sql.*;
import java.util.ArrayList;

public class PedidoDAO_DTO implements PedidoDAO {

    //final String insert ="insert into pedidos (idcliente,idcodigoarticulo,cantidad,fecha,estadopedido) VALUES (5,"art3",4,"date","Pendiente");";
    final String insert =" insert into pedidos (numeropedido,idcliente,idcodigoarticulo,cantidad,fecha,estadopedido) VALUES (?,?,?,?,?,?)";
    final String readall="select * from pedidos;";




    @Override
    public void Create(Pedido k) {
        PreparedStatement stat=null;
        int idGenerado=0;
        try {
            System.out.println("filas insertadas "+ k );
            Connection conn = Conexion_MySQL.getConnection();
            stat = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1,k.getNum_pedido());
            stat.setInt(2,k.getCliente().getIdCliente());
            stat.setString(3,k.getArticulo().getCodigo());
            stat.setInt(4,k.getCantidad());
            stat.setString(5,k.getArticulo().getCodigo());
            stat.setString(6,k.getArticulo().getCodigo());

            int filasInsercion=stat.executeUpdate();

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

    }

    @Override
    public ArrayList<Pedido> Read_all() {

        ArrayList<Pedido> pedidos = null;
        return pedidos;

    }
}
