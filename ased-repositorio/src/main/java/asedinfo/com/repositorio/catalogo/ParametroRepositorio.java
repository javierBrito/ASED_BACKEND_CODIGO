package asedinfo.com.repositorio.catalogo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asedinfo.com.modelo.catalogo.Parametro;

@Repository
public interface ParametroRepositorio extends JpaRepository<Parametro, Long> {

	List<Parametro> findByEstadoOrderByCodigo(String estado);

	Parametro findByNemonico(String nemonico);
	
	List<Parametro> findByNemonicoAndEstado(String nemonico, String estado);

	Parametro findByCodigo(Long codigo);
}
