package DAO;


import modelo.Pedido;

public interface PedidoDAO extends CRUD<Pedido,String>{



    void DeleteWithID (Integer idPedido);
}
