package pe.edu.upc.dao;

import pe.edu.upc.persistence.Articulo;
import java.util.List;

public interface ArticuloDao {
    List<Articulo> getArticulos();
    void registrar(Articulo articulo);
    Articulo consultarPorId(Long id);
    void actualizar(Articulo articulo);
}
