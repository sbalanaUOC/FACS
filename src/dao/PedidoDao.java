package dao;
import modelo.Pedido;
import java.util.*;
public interface PedidoDao {
    int insert(String emailCliente, String codigoArticulo, int unidades);
    void deleteIfCancelable(int idPedido);
    List<Pedido> findPendientes(String emailNullOk);
    List<Pedido> findEnviados(String emailNullOk);
}
