package pe.edu.upc.dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dao.PedidoDao;
import pe.edu.upc.dao.generic.AbstractDao;
import pe.edu.upc.persistence.Pedido;

import java.util.List;

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

    public Pedido consultarPorId(Long id) {
        return getByKey(id);
    }

    public void registrar(Pedido pedido) {
        persist(pedido);
    }

}
