package dao.mysql;
import dao.ClienteDao; import db.ConnectionManager; import modelo.*;
import java.sql.*; import java.util.*;
public class MySqlClienteDao implements ClienteDao {
    @Override public void insert(Cliente c){ /* (pega aquí la implementación JDBC que te pasé) */ }
    @Override public Optional<Cliente> findByEmail(String email){ return Optional.empty(); }
    @Override public List<Cliente> findAll(){ return List.of(); }
    @Override public List<Cliente> findByTipo(char tipo){ return List.of(); }
}