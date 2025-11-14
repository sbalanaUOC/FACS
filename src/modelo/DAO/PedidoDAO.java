package modelo.DAO;


import modelo.Pedido;

import java.util.ArrayList;

public interface PedidoDAO extends CRUD<Pedido,String>{



    void DeleteWithID (Integer idPedido);

    ArrayList<Pedido> ReadTable();

}
