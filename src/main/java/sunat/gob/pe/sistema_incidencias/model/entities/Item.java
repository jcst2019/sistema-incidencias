package sunat.gob.pe.sistema_incidencias.model.entities;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
	
    private ObjectProperty<Integer> idItem;
    private StringProperty descripcion;
    private StringProperty estado;
    
	public Item(Integer idItem, String descripcion,
			String estado) {
        this.idItem = new SimpleObjectProperty<>(idItem);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.estado = new SimpleStringProperty(estado);
	}

	public ObjectProperty<Integer> getIdItem() {
		return idItem;
	}

	public void setIdItem(ObjectProperty<Integer> idItem) {
		this.idItem = idItem;
	}

	public StringProperty getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(StringProperty descripcion) {
		this.descripcion = descripcion;
	}

	public StringProperty getEstado() {
		return estado;
	}

	public void setEstado(StringProperty estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return this.descripcion.get();
	}
    

}
