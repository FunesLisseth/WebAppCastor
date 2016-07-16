package pe.edu.upc.persistence;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente", schema = "castordb")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clie", nullable = false)
    private Long id;
    @Column(name = "ti_docu_iden", nullable = false)
    private String tipoDocumentoIdentidad;
    @Column(name = "nu_docu_iden", nullable = false)
    private String numeroDocumentoIdentidad;
    @Column(name = "tx_nomb", nullable = false)
    private String nombres;
    @Column(name = "tx_apel_pate", nullable = false)
    private String apellidoPaterno;
    @Column(name = "tx_apel_mate", nullable = false)
    private String apellidoMaterno;
    @Column(name = "tx_dire", nullable = false)
    private String direccion;
    @Column(name = "nu_telf", nullable = false)
    private String telefono;
    @Column(name = "tx_mail", nullable = false)
    private String correo;
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

    public String getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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