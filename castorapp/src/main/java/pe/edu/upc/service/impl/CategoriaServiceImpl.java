package pe.edu.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.dao.ArticuloDao;
import pe.edu.upc.dao.CategoriaDao;
import pe.edu.upc.persistence.Articulo;
import pe.edu.upc.persistence.Categoria;
import pe.edu.upc.service.ArticuloService;
import pe.edu.upc.service.CategoriaService;

import java.util.Date;
import java.util.List;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao categoriaDao;

    public List<Categoria> getCategorias() {
        return categoriaDao.getCategorias();
    }

    public List<Categoria> getCategorias(String estado) {
        return categoriaDao.getCategorias(estado);
    }

    public void registrar(Categoria categoria) {
        categoria.setActivo("1");
        categoria.setFechaCreacion(new Date());
        categoria.setUsuarioCreacion("ADMIN");
        categoriaDao.registrar(categoria);
    }

    public Categoria consultarPorId(Long id) {
        return categoriaDao.consultarPorId(id);
    }

    public void actualizar(Categoria categoria) {
        categoria.setFechaModificacion(new Date());
        categoria.setUsuarioModificacion("ADMIN");
        categoriaDao.actualizar(categoria);
    }

}
