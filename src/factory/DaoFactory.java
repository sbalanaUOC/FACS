package factory;
import dao.*; import dao.mysql.*;
public class DaoFactory {
    public static ClienteDao clienteDao(){ return new MySqlClienteDao(); }
    public static ArticuloDao articuloDao(){ return new MySqlArticuloDao(); }
    public static PedidoDao  pedidoDao(){   return new MySqlPedidoDao(); }
}
