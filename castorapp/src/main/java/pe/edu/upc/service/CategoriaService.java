package pe.edu.upc.service;

import pe.edu.upc.persistence.Articulo;
import pe.edu.upc.persistence.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getCategorias();
    List<Categoria> getCategorias(String estado);
    void registrar(Categoria categoria);
    Categoria consultarPorId(Long id);
    void actualizar(Categoria categoria);
}
