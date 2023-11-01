package sunat.gob.pe.sistema_incidencias.controller;

import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import sunat.gob.pe.sistema_incidencias.model.dao.IItem;
import sunat.gob.pe.sistema_incidencias.model.dao.IUsuarioDao;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.ItemDaoImpl;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.UsuarioDaoImpl;
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
	 public void initialize() {
		    inicializarComboBox(cbServicio, EnumTipoItem.SERVICIO);
		    inicializarComboBox(cbSubcategoria, EnumTipoItem.SUBCATEGORIA);
		    inicializarComboBox(cbImpacto, EnumTipoItem.IMPACTO);
		    inicializarComboBox(cbUrgencia, EnumTipoItem.URGENCIA);
	    }
	 
	 public Integer getSelectedId() {
	        Item selected = cbServicio.getSelectionModel().getSelectedItem();
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
}	 
