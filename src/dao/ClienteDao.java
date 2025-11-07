package dao;
import modelo.Cliente;
import java.util.*;
public interface ClienteDao {
    void insert(Cliente c);
    Optional<Cliente> findByEmail(String email);
    List<Cliente> findAll();
    List<Cliente> findByTipo(char tipo);
}