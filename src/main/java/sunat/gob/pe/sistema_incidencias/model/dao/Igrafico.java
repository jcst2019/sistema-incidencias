package sunat.gob.pe.sistema_incidencias.model.dao;

import java.util.List;

import sunat.gob.pe.sistema_incidencias.model.entities.barra;

public interface Igrafico {
     List <barra>  grafico1();
     String obtenerTotalIncidencias();
     String obtenerTotalUsuarios();
     String obtenerTotalUrgencias();
     String obtenerIncidenciaMaxima();
}
