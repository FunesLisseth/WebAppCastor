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
public class ArticuloController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ArticuloService articuloService;

    @RequestMapping(value={"/articulos","/articulos/"}, method = RequestMethod.GET)
    public String index(ModelMap model){
        return "articulosList.tiles";
    }

    @RequestMapping(value = { "/articulos/list" }, method = RequestMethod.GET)
    public
    @ResponseBody
    List<Articulo> list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Articulo> articuloList = null;
        try{
            articuloList = articuloService.getArticulos();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return articuloList;
    }

    @RequestMapping(value = { "/articulos/edit" }, method = RequestMethod.GET)
    public
    @ResponseBody
    Articulo edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Articulo articulo = null;
        try {
            String idArticulo = request.getParameter("idArticulo");
            if( idArticulo!=null&&!idArticulo.equals("") )
                articulo = articuloService.consultarPorId(new Long(idArticulo));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return articulo;
    }

    @RequestMapping(value = { "/articulos/register" }, method = RequestMethod.POST)
    public
    @ResponseBody
    String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        try {
            String idCategoria = request.getParameter("idCategoria");
            int aleatorio = (int) Math.floor(Math.random()*(100-999+1)+999);
            String descripcion = request.getParameter("descripcion");
            double pesoNeto = (request.getParameter("pesoNeto")!=null)?Double.parseDouble(request.getParameter("pesoNeto")):0;
            double pesoBruto = (request.getParameter("pesoBruto")!=null)?Double.parseDouble(request.getParameter("pesoBruto")):new Double(0);
            double volumen = (request.getParameter("volumen")!=null)?Double.parseDouble(request.getParameter("volumen")):new Double(0);
            String unidadMedida = request.getParameter("unidadMedida");
            double costoPromedioLocal = (request.getParameter("costoPromedioLocal")!=null)?Double.parseDouble(request.getParameter("costoPromedioLocal")):new Double(0);
            double costoPromedioDolar = (request.getParameter("costoPromedioDolar")!=null)?Double.parseDouble(request.getParameter("costoPromedioDolar")):new Double(0);
            double precioBaseLocal = (request.getParameter("precioBaseLocal")!=null)?Double.parseDouble(request.getParameter("precioBaseLocal")):new Double(0);
            double precioBaseDolar = (request.getParameter("precioBaseDolar")!=null)?Double.parseDouble(request.getParameter("precioBaseDolar")):new Double(0);

            Categoria categoria = categoriaService.consultarPorId(new Long(idCategoria));

            Articulo articulo = new Articulo();
            articulo.setCategoria(categoria);
            articulo.setCodigo("ART"+aleatorio);
            articulo.setDescripcion(descripcion);
            articulo.setPesoNeto(pesoNeto);
            articulo.setPesoBruto(pesoBruto);
            articulo.setVolumen(volumen);
            articulo.setUnidadMedida(unidadMedida);
            articulo.setCostoPromedioLocal(costoPromedioLocal);
            articulo.setCostoPromedioDolar(costoPromedioDolar);
            articulo.setPrecioBaseLocal(precioBaseLocal);
            articulo.setPrecioBaseDolar(precioBaseDolar);

            articuloService.registrar(articulo);
            result = "success";
        }catch(Exception ex){
            result = "error";
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = { "/articulos/update" }, method = RequestMethod.POST)
    public
    @ResponseBody
    String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        Articulo articulo = null;
        try {
            String idCategoria = request.getParameter("idCategoria");
            String idArticulo = request.getParameter("idArticulo");
            String descripcion = request.getParameter("descripcion");
            double pesoNeto = (request.getParameter("pesoNeto")!=null)?new Double(request.getParameter("pesoNeto")):new Double(0);
            double pesoBruto = (request.getParameter("pesoBruto")!=null)?new Double(request.getParameter("pesoBruto")):new Double(0);
            double volumen = (request.getParameter("volumen")!=null)?new Double(request.getParameter("volumen")):new Double(0);
            String unidadMedida = request.getParameter("unidadMedida");
            double costoPromedioLocal = (request.getParameter("costoPromedioLocal")!=null)?new Double(request.getParameter("costoPromedioLocal")):new Double(0);
            double costoPromedioDolar = (request.getParameter("costoPromedioDolar")!=null)?new Double(request.getParameter("costoPromedioDolar")):new Double(0);
            double precioBaseLocal = (request.getParameter("precioBaseLocal")!=null)?new Double(request.getParameter("precioBaseLocal")):new Double(0);
            double precioBaseDolar = (request.getParameter("precioBaseDolar")!=null)?new Double(request.getParameter("precioBaseDolar")):new Double(0);

            articulo = articuloService.consultarPorId(new Long(idArticulo));
            Categoria categoria = categoriaService.consultarPorId(new Long(idCategoria));

            if( articulo!=null ) {
                articulo.setCategoria(categoria);
                articulo.setDescripcion(descripcion);
                articulo.setPesoNeto(pesoNeto);
                articulo.setPesoBruto(pesoBruto);
                articulo.setVolumen(volumen);
                articulo.setUnidadMedida(unidadMedida);
                articulo.setCostoPromedioLocal(costoPromedioLocal);
                articulo.setCostoPromedioDolar(costoPromedioDolar);
                articulo.setPrecioBaseLocal(precioBaseLocal);
                articulo.setPrecioBaseDolar(precioBaseDolar);

                articuloService.actualizar(articulo);
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

    @RequestMapping(value = { "/articulos/state" }, method = RequestMethod.POST)
    public
    @ResponseBody
    String state(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String result = "";
        Articulo articulo = null;
        try {
            String idArticulo = request.getParameter("idArticulo");
            String estado = request.getParameter("estado");

            articulo = articuloService.consultarPorId(new Long(idArticulo));

            if( articulo!=null ) {
                articulo.setActivo(estado);
                articuloService.actualizar(articulo);
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
