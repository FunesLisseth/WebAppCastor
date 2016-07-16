package pe.edu.upc.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido", schema = "castordb")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedi", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_vend")
    private Vendedor vendedor;
    @OneToOne
    @JoinColumn(name = "id_clie")
    private Cliente cliente;

    @Column(name = "fe_pedi", nullable = false)
    private Date fechaPedido;
    @Column(name = "in_acti", nullable = false)
    private String activo;
    @Column(name = "tx_usua_crea", nullable = true)
    private String usuarioCreacion;
    @Column(name = "fe_usua_crea", nullable = true)
    private Date fechaCreacion;
    @Column(name = "tx_usua_modi", nullable = true)
    private String usuarioModificacion;
    @Column(name = "fe_usua_modi", nullable = true)
    private Date fechaModificacion;

    //@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name="id_pedi")
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_pedi")
    private Set<PedidoDetalle> pedidoDetalles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Set<PedidoDetalle> getPedidoDetalles() {
        return pedidoDetalles;
    }

    public void setPedidoDetalles(Set<PedidoDetalle> pedidoDetalles) {
        this.pedidoDetalles = pedidoDetalles;
    }
}