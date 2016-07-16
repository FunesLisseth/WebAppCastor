package pe.edu.upc.dao;

import pe.edu.upc.persistence.Pedido;

import java.util.List;

public interface PedidoDao {
    List<Pedido> getPedidos();
    Pedido consultarPorId(Long id);
    void registrar(Pedido pedido);
}
