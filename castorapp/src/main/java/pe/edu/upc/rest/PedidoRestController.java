package pe.edu.upc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pe.edu.upc.persistence.Pedido;
import pe.edu.upc.persistence.PedidoDetalle;
import pe.edu.upc.service.PedidoService;

import java.util.List;
import java.util.Set;

@RestController
public class PedidoRestController {

    @Autowired
    PedidoService pedidoService;

    @RequestMapping(value = "/rest/pedido", method = RequestMethod.GET)
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> pedidos = pedidoService.getPedidos();
        if(pedidos.isEmpty()){
            return new ResponseEntity<List<Pedido>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/pedido/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pedido> getPedido(@PathVariable("id") long id) {
        Pedido pedido = pedidoService.consultarPorId(id);
        if (pedido == null) {
            System.out.println("Pedido with id " + id + " not found");
            return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/pedido/add", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Pedido pedido, UriComponentsBuilder ucBuilder) {

        Set<PedidoDetalle> pedidoDetalles = pedido.getPedidoDetalles();
        pedido.setPedidoDetalles(null);
        pedidoService.registrar(pedido);

        for(PedidoDetalle pd:pedidoDetalles){
            pd.setIdPedido(pedido.getId());
        }
        pedidoService.registrarDetalle(pedidoDetalles);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/pedido/{id}").buildAndExpand(pedido.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
