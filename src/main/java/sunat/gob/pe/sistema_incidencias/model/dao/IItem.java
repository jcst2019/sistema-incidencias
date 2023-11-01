package sunat.gob.pe.sistema_incidencias.model.dao;

import java.util.List;

import sunat.gob.pe.sistema_incidencias.model.entities.Item;
import sunat.gob.pe.sistema_incidencias.model.util.EnumTipoItem;

public interface IItem {
	
    List<Item> obtenerListaItem( EnumTipoItem tipo );

}
