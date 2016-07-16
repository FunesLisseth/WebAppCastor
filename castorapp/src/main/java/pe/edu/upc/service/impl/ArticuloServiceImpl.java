package pe.edu.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.dao.ArticuloDao;
import pe.edu.upc.persistence.Articulo;
import pe.edu.upc.service.ArticuloService;

import java.util.Date;
import java.util.List;

@Service("articuloService")
@Transactional
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    ArticuloDao articuloDao;

    public List<Articulo> getArticulos() {
        return articuloDao.getArticulos();
    }

    public void registrar(Articulo articulo) {
        articulo.setActivo("1");
        articulo.setFechaCreacion(new Date());
        articulo.setUsuarioCreacion("ADMIN");
        articuloDao.registrar(articulo);
    }

    public Articulo consultarPorId(Long id) {
        return articuloDao.consultarPorId(id);
    }

    public void actualizar(Articulo articulo) {
        articulo.setFechaModificacion(new Date());
        articulo.setUsuarioModificacion("ADMIN");
        articuloDao.actualizar(articulo);
    }
}
