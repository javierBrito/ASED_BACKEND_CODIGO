package asedinfo.com.modelo.ahorro;
// default package

// Generated Oct 29, 2013 4:10:51 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import asedinfo.com.modelo.catalogo.Persona;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name = "aho_socio")
public class Socio implements java.io.Serializable {
	private static final long serialVersionUID = -8622196233866959952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false, precision = 10, scale = 0)
	private Long codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_inicio", length = 23)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fechaInicio;
	
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;

	@Column(name = "tipo_socio")
	private String tipoSocio;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cod_persona", nullable = false)
	private Persona persona;

	@Transient
	private Long codPersona;

	public Socio() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Long getCodPersona() {
		if (this.persona != null) {
			codPersona = this.persona.getCodigo();
		}

		return codPersona;
	}

	public void setCodPersona(Long codPersona) {
		this.codPersona = codPersona;
	}

	public String getTipoSocio() {
		return tipoSocio;
	}

	public void setTipoSocio(String tipoSocio) {
		this.tipoSocio = tipoSocio;
	}
}
