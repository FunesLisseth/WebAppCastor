package pe.edu.upc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.persistence.Articulo;
import pe.edu.upc.service.ArticuloService;
import java.util.List;

@RestController
public class ArticuloRestController {

    @Autowired
    ArticuloService articuloService;

    @RequestMapping(value = "/rest/articulos/", method = RequestMethod.GET)
    public ResponseEntity<List<Articulo>> getArticulos(){

        List<Articulo> articuloList = articuloService.getArticulos();

        if(articuloList.isEmpty()){
            return new ResponseEntity<List<Articulo>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Articulo>>(articuloList, HttpStatus.OK);
    }


}
