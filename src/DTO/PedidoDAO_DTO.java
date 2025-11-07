package DTO;

import DAO.PedidoDAO;
import modelo.Pedido;

import java.sql.Connection;
import java.util.List;

public class PedidoDAO_DTO implements PedidoDAO {

    private Connection conn;

    public PedidoDAO_DTO(Connection conn){
        this.conn=conn;
    }


    @Override
    public void Create(Pedido k) {

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
    public List<Pedido> Read_all() {
        return List.of();
    }
}
