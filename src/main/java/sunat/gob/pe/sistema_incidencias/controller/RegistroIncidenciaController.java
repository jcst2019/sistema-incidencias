package sunat.gob.pe.sistema_incidencias.controller;


import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sunat.gob.pe.sistema_incidencias.model.dao.IIncidencia;
import sunat.gob.pe.sistema_incidencias.model.dao.IItem;
import sunat.gob.pe.sistema_incidencias.model.dao.IUsuarioDao;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.IncidenciaDaoImpl;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.ItemDaoImpl;
import sunat.gob.pe.sistema_incidencias.model.entities.Incidencia;
import sunat.gob.pe.sistema_incidencias.model.entities.Item;
import sunat.gob.pe.sistema_incidencias.model.util.EnumTipoItem;

public class RegistroIncidenciaController {
	
	 @FXML
	 private ComboBox<Item> cbServicio;
	 
	 @FXML
	 private ComboBox<Item> cbSubcategoria;
	 
	 @FXML
	 private ComboBox<Item> cbImpacto;
	 
	 @FXML
	 private ComboBox<Item> cbUrgencia;
	 
	 @FXML
	 private TextField txtAsunto;
	 
	 @FXML
	 private TextArea txtADescripcion;
	 
	 @FXML
	 public void initialize() {
		    inicializarComboBox(cbServicio, EnumTipoItem.SERVICIO);
		    inicializarComboBox(cbSubcategoria, EnumTipoItem.SUBCATEGORIA);
		    inicializarComboBox(cbImpacto, EnumTipoItem.IMPACTO);
		    inicializarComboBox(cbUrgencia, EnumTipoItem.URGENCIA);
	    }
	 
	 public Integer getSelectedId(ComboBox<Item> comboBox) {
	        Item selected = comboBox.getSelectionModel().getSelectedItem();
	        return selected != null ? selected.getIdItem().get() : null;
	    }
	 private void inicializarComboBox(ComboBox<Item> comboBox, EnumTipoItem tipo) {
		    IItem itemdao = new ItemDaoImpl();
		    ObservableList<Item> listaItems = FXCollections.observableArrayList(itemdao.obtenerListaItem(tipo));
		    comboBox.setItems(listaItems);
		    comboBox.setCellFactory(item -> new javafx.scene.control.ListCell<Item>() {
		        @Override
		        protected void updateItem(Item item, boolean empty) {
		            super.updateItem(item, empty);
		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item.getDescripcion().get());
		            }
		        }
		    });
	 	}
	  public void guardarIncidencia() {
		  
	        int idServicio = cbServicio.getSelectionModel().getSelectedItem().getIdItem().get();
	        int idSubcategoria = getSelectedId(cbSubcategoria);
	        int idImpacto = cbImpacto.getSelectionModel().getSelectedItem().getIdItem().get();
	        int idUrgencia = cbUrgencia.getSelectionModel().getSelectedItem().getIdItem().get();
	        String asunto = txtAsunto.getText();
	        String descripcion = txtADescripcion.getText();
	        String estado = "A";
	        System.out.println("ID Servicio: " + idServicio);
	        System.out.println("ID Subcategoría: " + idSubcategoria);
	        System.out.println("ID Impacto: " + idImpacto);
	        System.out.println("ID Urgencia: " + idUrgencia);
	        System.out.println("Asunto: " + asunto);
	        System.out.println("Descripción: " + descripcion);
	        System.out.println("Estado: " + estado);
	        Incidencia incidencia = new Incidencia();
	        incidencia.setIdServicios(new SimpleObjectProperty<>(idServicio));
	        incidencia.setIdSubcategoria(new SimpleObjectProperty<>(idSubcategoria));
	        incidencia.setIdImpacto(new SimpleObjectProperty<>(idImpacto));
	        incidencia.setIdUrgencia(new SimpleObjectProperty<>(idUrgencia));
	        incidencia.setAsunto(new SimpleStringProperty(asunto));
	        incidencia.setDescripcion(new SimpleStringProperty(descripcion));
	        incidencia.setEstado(new SimpleStringProperty(estado));
	        System.out.println(incidencia);
	        IIncidencia incidenciaDao = new IncidenciaDaoImpl();
	        incidenciaDao.guardarIncidencia(incidencia);
	    }
}	 
