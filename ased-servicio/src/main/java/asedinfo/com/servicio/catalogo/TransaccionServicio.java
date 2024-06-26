package asedinfo.com.servicio.catalogo;

import java.util.List;

import asedinfo.com.modelo.catalogo.Transaccion;

public interface TransaccionServicio {
	/**
	 * Permite listar Transaccion
	 * 
	 * @param null
	 * @return lista Transaccion
	 */
	List<Transaccion> listarTodosTransaccion();

	/**
	 * Permite listar Transaccion Activo
	 * 
	 * @param nemonicoModulo, estado
	 * @return lista Transaccion
	 */
	List<Transaccion> listarTransaccionActivo(String nemonicoModulo);

	/**
	 * Permite obtener Transaccion
	 * 
	 * @param codigo
	 * @return Transaccion
	 */
	Transaccion buscarTransaccionPorCodigo(Long codigo);

	/**
	 * Permite obtener lista Transaccion
	 * 
	 * @param descripcion
	 * @return listaTransaccion
	 */
	List<Transaccion> listarTransaccionPorDescripcion(String descripcion);

	/**
	 * Permite obtener lista Transaccion
	 * 
	 * @param codCliente
	 * @return listaTransaccion
	 */
	List<Transaccion> listarTransaccionPorCliente(Long codCliente);

	List<Transaccion> listarTransaccionPorProducto(Long codProducto);

	List<Transaccion> listarTransaccionPorClienteYProducto(Long codCliente, Long codProducto);

	/**
	 * Permite obtener lista Transaccion
	 * 
	 * @param claveCuenta
	 * @return listaTransaccion
	 */
	List<Transaccion> listarTransaccionPorClaveCuenta(String claveCuenta);

	/**
	 * Permite obtener lista Transaccion
	 * 
	 * @param rango fechas
	 * @return listaTransaccion
	 */
	List<Transaccion> listarTransaccionPorRangoFechas(String fechaInicio, String fechaFin);

	/**
	 * Permite obtener lista Transaccion
	 * 
	 * @param num dias
	 * @return listaTransaccion
	 */
	List<Transaccion> listarTransaccionACaducarse(int numDias);

	/**
	 * Permite registrar Transaccion
	 * 
	 * @param Transaccion
	 * @return Transaccion
	 */
	Transaccion registrar(Transaccion Transaccion);
	Transaccion crearTransaccion(Transaccion transaccion);

	List<Transaccion> buscarPorDescripcion(String descripcion);
	
}
