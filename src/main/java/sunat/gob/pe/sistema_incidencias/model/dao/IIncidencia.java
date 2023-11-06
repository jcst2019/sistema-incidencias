package sunat.gob.pe.sistema_incidencias.model.dao;

import java.util.List;

import sunat.gob.pe.sistema_incidencias.model.entities.Incidencia;

public interface IIncidencia {
	
	boolean  guardarIncidencia(Incidencia incidencia);
	List<Incidencia> busquedaTotalIncidencias();
	String obtenerDescripcionServicio(int idServicio);
	String obtenerDescripcionSubcategoria(int idSubcategoria);
	String obtenerDescripcionImpacto(int idImpacto);
	String obtenerDescripcionUrgencia(int idUrgencia);

}
