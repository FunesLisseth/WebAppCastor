package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.upc.persistence.Articulo;
import pe.edu.upc.persistence.Categoria;
import pe.edu.upc.service.ArticuloService;
import pe.edu.upc.service.CategoriaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @RequestMapping(value={"/categorias","/categorias/"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        return "categoriasList.tiles";
    }

    @RequestMapping(value = { "/categorias/list" }, method = RequestMethod.GET)
    public
    @ResponseBody
    List<Categoria> list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Categoria> categoriaList = null;
        try{
            String activo = request.getParameter("activo");
            if( activo!=null&&!activo.equals("") ){
                categoriaList = categoriaService.getCategorias(activo);
            }else{
                categoriaList = categoriaService.getCategorias();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return categoriaList;
    }

    @RequestMapping(value = { "/categorias/edit" }, method = RequestMethod.GET)
    public
    @ResponseBody
    Categoria edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Categoria categoria = null;
        try {
            String id = request.getParameter("idCategoria");
            if( id!=null&&!id.equals("") )
                categoria = categoriaService.consultarPorId(new Long(id));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return categoria;
    }

    @RequestMapping(value = { "/categorias/register" }, method = RequestMethod.POST)
    public
    @ResponseBody
    String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        try {
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Categoria categoria = new Categoria();
            categoria.setNombre(nombre);
            categoria.setDescripcion(descripcion);
            categoriaService.registrar(categoria);
            result = "success";
        }catch(Exception ex){
            result = "error";
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = { "/categorias/update" }, method = RequestMethod.POST)
    public
    @ResponseBody
    String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        Categoria categoria = null;
        try {
            String id = request.getParameter("idCategoria");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");

            categoria = categoriaService.consultarPorId(new Long(id));

            if( categoria!=null ) {
                categoria.setNombre(nombre);
                categoria.setDescripcion(descripcion);
                categoriaService.actualizar(categoria);
                result = "success";
            }else{
                result = "notfound";
            }

        }catch(Exception ex){
            result = "error";
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = { "/categorias/state" }, method = RequestMethod.POST)
    public
    @ResponseBody
    String state(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        Categoria categoria = null;
        try {
            String id = request.getParameter("idCategoria");
            String estado = request.getParameter("estado");

            categoria = categoriaService.consultarPorId(new Long(id));

            if( categoria!=null ) {
                categoria.setActivo(estado);
                categoriaService.actualizar(categoria);
                result = "success";
            }else{
                result = "notfound";
            }

        }catch(Exception ex){
            result = "error";
            ex.printStackTrace();
        }
        return result;
    }

}
