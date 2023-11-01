package sunat.gob.pe.sistema_incidencias.model.entities;

import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Incidencia {
	
    private ObjectProperty<Integer> idIncidencias;
    private ObjectProperty<Integer> idServicios;
    //private StringProperty fechaRegistro;
    private StringProperty asunto;
    private StringProperty descripcion;
    private StringProperty estado;
    
	public Incidencia(ObjectProperty<Integer> idIncidencias, ObjectProperty<Integer> idServicios, StringProperty asunto,
			StringProperty descripcion, StringProperty estado) {
		super();
		this.idIncidencias = idIncidencias;
		this.idServicios = idServicios;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public ObjectProperty<Integer> getIdIncidencias() {
		return idIncidencias;
	}

	public void setIdIncidencias(ObjectProperty<Integer> idIncidencias) {
		this.idIncidencias = idIncidencias;
	}

	public ObjectProperty<Integer> getIdServicios() {
		return idServicios;
	}

	public void setIdServicios(ObjectProperty<Integer> idServicios) {
		this.idServicios = idServicios;
	}

	public StringProperty getAsunto() {
		return asunto;
	}

	public void setAsunto(StringProperty asunto) {
		this.asunto = asunto;
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
		return "Incidencia [idIncidencias=" + idIncidencias + ", idServicios=" + idServicios + ", asunto=" + asunto
				+ ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	

}
