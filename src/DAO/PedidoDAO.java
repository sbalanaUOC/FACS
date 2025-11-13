package DAO;


import modelo.Cliente;
import modelo.Pedido;
import modelo.Tablapedido;

import java.util.ArrayList;

public interface PedidoDAO extends CRUD<Pedido,String>{



    void DeleteWithID (Integer idPedido);

    ArrayList<Pedido> ReadTable();

}
