package modelo;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void testCalcularImporteTotalClienteNormal() {
        Cliente cliente = new Cliente("normal@gmail.com", "Cliente Normal", "Calle Uno", "111A");
        Articulo articulo = new Articulo("A01", "Tablero MDF", 100.0f, 10.0f, 3);

        Pedido pedido = new Pedido(1, cliente, articulo, 2, LocalDateTime.now(), EstadoPedido.Pendiente);

        float total = pedido.CalcularImporteTotal();
        // 100 * 2 + 10 = 210
        assertEquals(210.0f, total, 0.001, "El total debe ser precio*cantidad + gastos de envío");
    }

    @Test
    void testCalcularImporteTotalClientePremium() {
        ClientePremium premium = new ClientePremium("premium@gmail.com", "Cliente Premium", "Calle Dos", "222B");
        Articulo articulo = new Articulo("A02", "Barniz", 50.0f, 20.0f, 2);

        Pedido pedido = new Pedido(2, premium, articulo, 1, LocalDateTime.now(), EstadoPedido.Pendiente);

        float total = pedido.CalcularImporteTotal();
        // Descuento = 20% de 20 = 4 → total = 50*1 + (20 - 4) = 66
        assertEquals(66.0f, total, 0.001, "Debe aplicarse el descuento premium del 20% en los gastos de envío");
    }
}
