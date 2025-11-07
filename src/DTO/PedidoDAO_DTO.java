package DTO;

import DAO.PedidoDAO;
import modelo.Cliente;
import modelo.Pedido;

import java.util.ArrayList;

public class PedidoDAO_DTO implements PedidoDAO {




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
    public ArrayList<Pedido> Read_all() {

        ArrayList<Pedido> pedidos = null;
        return pedidos;

    }
}
