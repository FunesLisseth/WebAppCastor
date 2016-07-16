package pe.edu.upc.service;

import pe.edu.upc.persistence.Articulo;
import java.util.List;

public interface ArticuloService {
    List<Articulo> getArticulos();
    void registrar(Articulo Articulo);
    Articulo consultarPorId(Long id);
    void actualizar(Articulo Articulo);
}
