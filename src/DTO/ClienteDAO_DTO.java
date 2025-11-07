package DTO;

import DAO.ClienteDAO;
import modelo.Cliente;

import java.sql.Connection;
import java.util.List;

public class ClienteDAO_DTO implements ClienteDAO {

    private Connection conn;

    public ClienteDAO_DTO(Connection conn){
        this.conn=conn;
    }

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
    public List<Cliente> Read_all() {
        return List.of();
    }
}
