package dao.mysql;
import dao.ArticuloDao; import db.ConnectionManager; import modelo.Articulo;
import java.sql.*; import java.util.*;
public class MySqlArticuloDao implements ArticuloDao {
    @Override public void insert(Articulo a){ /* pega implementación JDBC */ }
    @Override public Optional<Articulo> findByCodigo(String codigo){ return Optional.empty(); }
    @Override public List<Articulo> findAll(){ return List.of(); }
}