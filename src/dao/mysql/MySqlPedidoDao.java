package dao.mysql;
import dao.PedidoDao; import db.ConnectionManager; import modelo.*;
import java.sql.*; import java.util.*;
public class MySqlPedidoDao implements PedidoDao {
    @Override public int insert(String emailCliente, String codigoArticulo, int unidades){ return 0; }
    @Override public void deleteIfCancelable(int idPedido){ /* llama al SP */ }
    @Override public List<Pedido> findPendientes(String emailNullOk){ return List.of(); }
    @Override public List<Pedido> findEnviados(String emailNullOk){ return List.of(); }
}