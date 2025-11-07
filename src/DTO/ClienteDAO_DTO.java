package DTO;

import DAO.ClienteDAO;
import modelo.Cliente;

import java.util.ArrayList;

public class ClienteDAO_DTO implements ClienteDAO {



    @Override
    public void Create(Cliente k) {

    }

    @Override
    public Cliente Read() {
        return null;
    }

    @Override
    public void Update(Cliente k) {

    }

    @Override
    public void Delete(Cliente k) {

    }

    @Override
    public ArrayList<Cliente> Read_all() {

        //Cliente clientes = new ArrayList<>();

        ArrayList<Cliente> clientes = null;
        return clientes;
    }
}
