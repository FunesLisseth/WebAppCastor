package pe.edu.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.dao.CategoriaDao;
import pe.edu.upc.dao.PedidoDao;
import pe.edu.upc.persistence.Categoria;
import pe.edu.upc.persistence.Pedido;
import pe.edu.upc.persistence.PedidoDetalle;
import pe.edu.upc.service.CategoriaService;
import pe.edu.upc.service.PedidoService;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service("pedidoService")
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;

    public List<Pedido> getPedidos() {
        return pedidoDao.getPedidos();
    }

    public Pedido getPedido(Pedido pedido) {
        return pedidoDao.getPedido(pedido);
    }

    public Pedido consultarPorId(Long id) {
        return pedidoDao.consultarPorId(id);
    }

    public void registrar(Pedido pedido) {
        pedido.setActivo("1");
        pedido.setFechaCreacion(new Date());
        pedido.setUsuarioCreacion("ADMIN");
        pedidoDao.registrar(pedido);
    }

    public void refresh(Pedido pedido){
        pedidoDao.refresh(pedido);
    }

    @Override
    public void registrarDetalle(Set<PedidoDetalle> pedidoDetalles) {
        pedidoDao.registrarDetalle(pedidoDetalles);
    }

}
