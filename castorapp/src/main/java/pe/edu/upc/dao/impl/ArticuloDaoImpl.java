package pe.edu.upc.dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dao.ArticuloDao;
import pe.edu.upc.dao.generic.AbstractDao;
import pe.edu.upc.persistence.Articulo;
import java.util.List;

@Repository("articuloDao")
public class ArticuloDaoImpl extends AbstractDao<Long,Articulo> implements ArticuloDao {

    public List<Articulo> getArticulos() {
        List<Articulo> articuloList = null;
        try {
            Criteria criteria = createEntityCriteria();
            articuloList = (List<Articulo>)criteria.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return articuloList;
    }

    public void registrar(Articulo articulo) {
        persist(articulo);
    }

    public Articulo consultarPorId(Long id) {
        return getByKey(id);
    }

    public void actualizar(Articulo articulo) {
        merge(articulo);
    }
}
