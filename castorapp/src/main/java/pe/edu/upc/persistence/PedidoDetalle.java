package pe.edu.upc.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedido_detalle", schema = "castordb")
public class PedidoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedi_deta", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedi")
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "id_arti")
    private Articulo articulo;

    @Column(name = "nu_cant", nullable = false)
    private int cantidad;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
}