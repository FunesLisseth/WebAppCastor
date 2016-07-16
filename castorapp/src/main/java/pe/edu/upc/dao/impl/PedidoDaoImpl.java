package pe.edu.upc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dao.PedidoDao;
import pe.edu.upc.dao.generic.AbstractDao;
import pe.edu.upc.persistence.Pedido;
import pe.edu.upc.persistence.PedidoDetalle;

import java.util.List;
import java.util.Set;

@Repository("pedidoDao")
public class PedidoDaoImpl extends AbstractDao<Long,Pedido> implements PedidoDao {

    public List<Pedido> getPedidos() {
        List<Pedido> pedidos = null;
        try {
            Criteria criteria = createEntityCriteria();
            pedidos = (List<Pedido>)criteria.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return pedidos;
    }

    public Pedido getPedido(Pedido pedido) {
        Pedido pedido1 = null;
        try {
            Criteria criteria = createEntityCriteria();
            criteria.add(Restrictions.eq("fechaCreacion",pedido.getFechaCreacion()));
            pedido1 = (Pedido)criteria.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return pedido1;
    }

    public Pedido consultarPorId(Long id) {
        Pedido pedido = getByKey(id);
        Hibernate.initialize(pedido.getPedidoDetalles());
        return pedido;
    }

    public void registrar(Pedido pedido) {
        Hibernate.initialize(pedido.getPedidoDetalles());
        persist(pedido);
    }

    public void refresh(Pedido pedido){
        refresh(pedido);
    }

    @Override
    public void registrarDetalle(Set<PedidoDetalle> pedidoDetalles) {
        getSession().createCriteria(PedidoDetalle.class);
        for (PedidoDetalle pd:pedidoDetalles) {
            getSession().persist(pd);
        }
    }

}
