package sunat.gob.pe.sistema_incidencias.model.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class Incidencia {
	
    private ObjectProperty<Integer> idIncidencia;
    private ObjectProperty<Integer> idServicios;
    private ObjectProperty<Integer> idSubcategoria;
    private ObjectProperty<Integer> idImpacto;
    private ObjectProperty<Integer> idUrgencia;
    //private StringProperty fechaRegistro;
    private StringProperty asunto;
    private StringProperty descripcion;
    private ObjectProperty<LocalDateTime> fechaRegistro;
    private StringProperty estado;
    
	public Incidencia() {
		super();
	}

	public Incidencia(ObjectProperty<Integer> idIncidencia, ObjectProperty<Integer> idServicios, ObjectProperty<Integer> idSubcategoria, ObjectProperty<Integer> idImpacto, ObjectProperty<Integer> idUrgencia, 
			StringProperty asunto,
			StringProperty descripcion,ObjectProperty<LocalDateTime> fechaRegistro, StringProperty estado) {
		super();
		this.idIncidencia = idIncidencia;
		this.idServicios = idServicios;
		this.idServicios = idSubcategoria;
		this.idServicios = idImpacto;
		this.idServicios = idUrgencia;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.fechaRegistro= fechaRegistro;
		this.estado = estado;
	}

	public ObjectProperty<Integer> getIdIncidencia() {
		return idIncidencia;
	}

	public void setIdIncidencia(ObjectProperty<Integer> idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public ObjectProperty<Integer> getIdServicio() {
		return idServicios;
	}
	
	public void setIdServicios(ObjectProperty<Integer> idServicios) {
		this.idServicios = idServicios;
	}
	
	public void setIdSubcategoria(ObjectProperty<Integer> idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}
	
	public ObjectProperty<Integer> getIdSubcategoria() {
		return idSubcategoria;
	}
	
	public void setIdImpacto(ObjectProperty<Integer> idImpacto) {
		this.idImpacto = idImpacto;
	}
	
	public ObjectProperty<Integer> getIdImpacto() {
		return idImpacto;
	}
	
	public void setIdUrgencia(ObjectProperty<Integer> idUrgencia) {
		this.idUrgencia = idUrgencia;
	}
	
	public ObjectProperty<Integer> getIdUrgencia() {
		return idUrgencia;
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
	
	public ObjectProperty<LocalDateTime> getFechaRegistro() {
	    return fechaRegistro;
	}

	public void setFechaRegistro(ObjectProperty<LocalDateTime> fechaRegistro) {
	    this.fechaRegistro = fechaRegistro;
	}

	public StringProperty getEstado() {
		return estado;
	}

	public void setEstado(StringProperty estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Incidencia [idIncidencia=" + idIncidencia + ", idServicios=" + idServicios + ", idSubcategoria="
				+ idSubcategoria + ", idImpacto=" + idImpacto + ", idUrgencia=" + idUrgencia + ", asunto=" + asunto
				+ ", descripcion=" + descripcion + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + "]";
	}

}
