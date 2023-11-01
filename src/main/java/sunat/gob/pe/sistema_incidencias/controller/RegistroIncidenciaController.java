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

public class RegistroIncidenciaController {
	
	 @FXML
	 private ComboBox<Item> cbServicio;
	 
	 @FXML
	 public void initialize() {
		IItem itemdao = new ItemDaoImpl();
	    //List<Item> listaServicio = itemdao.obtenerListaItem();
	    //cbServicio.getItems().addAll(listaServicio);
	        ObservableList<Item> listaServicio = FXCollections.observableArrayList(itemdao.obtenerListaItem());
	        cbServicio.setItems(listaServicio);
	        cbServicio.setCellFactory(item -> new javafx.scene.control.ListCell<Item>() {
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
	
	 public Integer getSelectedId() {
	        Item selected = cbServicio.getSelectionModel().getSelectedItem();
	        return selected != null ? selected.getIdItem().get() : null;
	    }	 
}	 
