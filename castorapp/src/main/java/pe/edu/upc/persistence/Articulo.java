package pe.edu.upc.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "articulo", schema = "castordb")
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arti", nullable = false)
    private Long id;
    @Column(name = "co_arti", nullable = false)
    private String codigo;
    @Column(name = "tx_desc_arti", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_cate")
    private Categoria categoria;

    @Column(name = "nu_peso_neto", nullable = false)
    private double pesoNeto;
    @Column(name = "nu_peso_brut", nullable = false)
    private double pesoBruto;
    @Column(name = "nu_volu", nullable = false)
    private double volumen;
    @Column(name = "tx_unid_medi", nullable = false)
    private String unidadMedida;
    @Column(name = "nu_cost_prom_loca", nullable = false)
    private double costoPromedioLocal;
    @Column(name = "nu_cost_prom_dola", nullable = false)
    private double costoPromedioDolar;
    @Column(name = "nu_prec_base_loca", nullable = false)
    private double precioBaseLocal;
    @Column(name = "nu_prec_base_dola", nullable = false)
    private double precioBaseDolar;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(double pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getCostoPromedioLocal() {
        return costoPromedioLocal;
    }

    public void setCostoPromedioLocal(double costoPromedioLocal) {
        this.costoPromedioLocal = costoPromedioLocal;
    }

    public double getCostoPromedioDolar() {
        return costoPromedioDolar;
    }

    public void setCostoPromedioDolar(double costoPromedioDolar) {
        this.costoPromedioDolar = costoPromedioDolar;
    }

    public double getPrecioBaseLocal() {
        return precioBaseLocal;
    }

    public void setPrecioBaseLocal(double precioBaseLocal) {
        this.precioBaseLocal = precioBaseLocal;
    }

    public double getPrecioBaseDolar() {
        return precioBaseDolar;
    }

    public void setPrecioBaseDolar(double precioBaseDolar) {
        this.precioBaseDolar = precioBaseDolar;
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