package asedinfo.com.servicio.impl.seguridad;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asedinfo.com.modelo.seguridad.Sede;
import asedinfo.com.repositorio.seguridad.SedeRepositorio;
import asedinfo.com.servicio.seguridad.SedeServicio;

@Service
public class SedeServicioImpl implements SedeServicio {

	@Autowired
	private SedeRepositorio sedeRepositorio;
	@Autowired
	private SedeServicio sedeServicio;

	@Override
	public List<Sede> listarTodosSede() {
		return sedeRepositorio.findAll();
	}

	@Override
	public List<Sede> listarSedeActivo(String estado) {
		return sedeRepositorio.findByEstado(estado);
	}

	@Override
	public List<Sede> listarSedeSuperior() {
		return sedeRepositorio.listarSedeSuperior();
	}
	
	@Override
	public Sede buscarSedePorCodigo(Long codigo) {
		return sedeRepositorio.findByCodigo(codigo);
	}
	
	@Override
	public Sede registrar(Sede sede) {
		if (sede.getCodigoSedeSuperior() != null && sede.getCodigoSedeSuperior() != 0) {
			Sede sedeSuperior = new Sede();
			sedeSuperior = sedeServicio.buscarSedePorCodigo(sede.getCodigoSedeSuperior());
			if (sedeSuperior != null) {
				sede.setSedeSuperior(sedeSuperior);
			}
		}
		return sedeRepositorio.save(sede);
	}
}
