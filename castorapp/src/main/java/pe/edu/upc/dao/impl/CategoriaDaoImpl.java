package pe.edu.upc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.edu.upc.dao.ArticuloDao;
import pe.edu.upc.dao.CategoriaDao;
import pe.edu.upc.dao.generic.AbstractDao;
import pe.edu.upc.persistence.Articulo;
import pe.edu.upc.persistence.Categoria;

import java.util.List;

@Repository("categoriaDao")
public class CategoriaDaoImpl extends AbstractDao<Long,Categoria> implements CategoriaDao {

    public List<Categoria> getCategorias() {
        List<Categoria> categoriaList = null;
        try {
            Criteria criteria = createEntityCriteria();
            categoriaList = (List<Categoria>)criteria.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return categoriaList;
    }

    public List<Categoria> getCategorias(String estado) {
        List<Categoria> categoriaList = null;
        try {
            Criteria criteria = createEntityCriteria();
            criteria.add(Restrictions.eq("activo", estado));
            categoriaList = (List<Categoria>)criteria.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return categoriaList;
    }

    public void registrar(Categoria categoria) {
        persist(categoria);
    }

    public Categoria consultarPorId(Long id) {
        return getByKey(id);
    }

    public void actualizar(Categoria categoria) {
        merge(categoria);
    }

}
