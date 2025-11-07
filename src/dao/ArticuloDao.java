package dao;
import modelo.Articulo;
import java.util.*;
public interface ArticuloDao {
    void insert(Articulo a);
    Optional<Articulo> findByCodigo(String codigo);
    List<Articulo> findAll();
}