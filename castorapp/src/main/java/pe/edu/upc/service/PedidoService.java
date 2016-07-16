package pe.edu.upc.service;

import pe.edu.upc.persistence.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> getPedidos();
    Pedido consultarPorId(Long id);
    void registrar(Pedido pedido);
}
