package pe.edu.upc.dao;

import pe.edu.upc.persistence.Pedido;
import pe.edu.upc.persistence.PedidoDetalle;

import java.util.List;
import java.util.Set;

public interface PedidoDao {
    List<Pedido> getPedidos();
    Pedido getPedido(Pedido pedido);
    Pedido consultarPorId(Long id);
    void registrar(Pedido pedido);
    void refresh(Pedido pedido);

    void registrarDetalle(Set<PedidoDetalle> pedidoDetalles);
}
