package sunat.gob.pe.sistema_incidencias.model.dao;

import java.util.List;

import sunat.gob.pe.sistema_incidencias.model.entities.Incidencia;

public interface IIncidencia {
	
	boolean  guardarIncidencia(Incidencia incidencia);
	List<Incidencia> busquedaTotalIncidencias();

}
