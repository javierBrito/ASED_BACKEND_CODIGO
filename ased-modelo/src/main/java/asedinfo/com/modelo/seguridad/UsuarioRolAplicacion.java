package asedinfo.com.modelo.seguridad;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * UsuarioRolAplicacion generated by hbm2java
 */
@Entity
@Table(name = "seg_usuario_rol_aplicacion")
public class UsuarioRolAplicacion implements java.io.Serializable {
	private static final long serialVersionUID = 7862034547880429559L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "fecha_inicial", nullable = false)
	private Date fechaInicial;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	@Column(name = "fecha_final", nullable = false)
	private Date fechaFinal;

	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usuario", nullable = false)
	private Usuario usuario;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_rol_aplicacion", nullable = false)
	private RolAplicacion rolAplicacion;

	@Transient
	private Long codRolAplicacion;
	@Transient
	private Long codUsuario;

	public UsuarioRolAplicacion() {
	}

	public UsuarioRolAplicacion(Long codigo, Usuario usuario, RolAplicacion rolAplicacion, Date fechaInicial) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.rolAplicacion = rolAplicacion;
		this.fechaInicial = fechaInicial;
	}

	public UsuarioRolAplicacion(Long codigo, Usuario usuario, RolAplicacion rolAplicacion, Date fechaInicial,
			Date fechaFinal) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.rolAplicacion = rolAplicacion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public RolAplicacion getRolAplicacion() {
		return this.rolAplicacion;
	}

	public void setRolAplicacion(RolAplicacion rolAplicacion) {
		this.rolAplicacion = rolAplicacion;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Long getCodRolAplicacion() {
		if (this.rolAplicacion != null) {
			codRolAplicacion = this.rolAplicacion.getCodigo();
		}
		return codRolAplicacion;
	}

	public void setCodRolAplicacion(Long codRolAplicacion) {
		this.codRolAplicacion = codRolAplicacion;
	}

	public Long getCodUsuario() {
		if (this.usuario != null) {
			codUsuario = this.usuario.getCodigo();
		}
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
