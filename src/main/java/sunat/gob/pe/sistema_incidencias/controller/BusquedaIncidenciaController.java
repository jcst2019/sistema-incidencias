package sunat.gob.pe.sistema_incidencias.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sunat.gob.pe.sistema_incidencias.model.dao.IIncidencia;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.IncidenciaDaoImpl;
import sunat.gob.pe.sistema_incidencias.model.entities.Incidencia;
import sunat.gob.pe.sistema_incidencias.model.entities.TipoBusqueda;
import sunat.gob.pe.sistema_incidencias.model.util.EnumTipoBusqueda;

public class BusquedaIncidenciaController implements Initializable{
	
    @FXML
    private ComboBox<TipoBusqueda> cmbBuscarIncidente;
    
	@FXML
	private TextField txtBusquedaIncidente;
	
    @FXML
    private TableView<Incidencia> incidentesTable;
    
    @FXML
    private TableColumn<Incidencia, Integer> idColumn;
    
    @FXML
    private TableColumn<Incidencia, Integer> idUsuarioRegistraColum;
    
    @FXML
    private TableColumn<Incidencia, String> asuntoColumn;
    
    @FXML
    private TableColumn<Incidencia, String> descripcionColumn;
    
    @FXML
    private TableColumn<Incidencia, LocalDateTime> fechaRegistroColumn;
    
    @FXML
    private TableColumn<Incidencia, String> servicioColumn;
    
    @FXML
    private TableColumn<Incidencia, String> subcategoriaColumn;
    
    @FXML
    private TableColumn<Incidencia, String> impactoColumn;
    
    @FXML
    private TableColumn<Incidencia, String> urgenciaColumn;
    
    
    private ObservableList<Incidencia> incidenciaData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        System.out.println("BusquedaIncidenciaController initialize");
        llenarTiposBusqueda();
        enlazarTabla();
        //llenarDatosEnTabla();
		
	}
	@FXML
	private void onComboBoxSelection() {
	    habilitarCampos();
	}
    private void llenarTiposBusqueda() {
    	
    	ObservableList<TipoBusqueda> tiposBusqueda = FXCollections.observableArrayList(
    	        new TipoBusqueda(1, "Todos"),
    	       new TipoBusqueda(2, "Usuario Registra"),
    	        new TipoBusqueda(3, "Numero Incidencia")
    	);
    	cmbBuscarIncidente.setItems(tiposBusqueda);
    	
    	//ObservableList<EnumTipoBusqueda> tiposBusqueda = FXCollections.observableArrayList(EnumTipoBusqueda.values());
    	//cmbBuscarIncidente.setItems(tiposBusqueda);

    }
    private void enlazarTabla() {
    	IIncidencia incidenciaDao = new IncidenciaDaoImpl();
    	incidentesTable.setItems(incidenciaData);

        idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdIncidencia());
        idUsuarioRegistraColum.setCellValueFactory(rowData -> rowData.getValue().getIdUsuarioRegistra());
        asuntoColumn.setCellValueFactory(rowData -> rowData.getValue().getAsunto());
        descripcionColumn.setCellValueFactory(rowData -> rowData.getValue().getDescripcion());
        fechaRegistroColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaRegistro());
        fechaRegistroColumn.setCellFactory(column -> {
            return new TableCell<Incidencia, LocalDateTime>() {
                @Override
                protected void updateItem(LocalDateTime item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
                    }
                }
            };
        });
        servicioColumn.setCellValueFactory(cellData -> {
            int idServicio = cellData.getValue().getIdServicio().get();
            return new SimpleStringProperty(incidenciaDao.obtenerDescripcionServicio(idServicio));
        });

        subcategoriaColumn.setCellValueFactory(cellData -> {
            int idSubcategoria = cellData.getValue().getIdSubcategoria().get();
            return new SimpleStringProperty(incidenciaDao.obtenerDescripcionSubcategoria(idSubcategoria));
        });

        impactoColumn.setCellValueFactory(cellData -> {
            int idImpacto = cellData.getValue().getIdImpacto().get();
            return new SimpleStringProperty(incidenciaDao.obtenerDescripcionImpacto(idImpacto));
        });

        urgenciaColumn.setCellValueFactory(cellData -> {
            int idUrgencia = cellData.getValue().getIdUrgencia().get();
            return new SimpleStringProperty(incidenciaDao.obtenerDescripcionUrgencia(idUrgencia));
        });

    }
    
    private void llenarDatosEnTabla() {
        IIncidencia incidenciaDao = new IncidenciaDaoImpl();
        incidenciaData.clear(); // Elimina todos los elementos existentes en la lista
        incidenciaData.addAll(incidenciaDao.busquedaTotalIncidencias());
    }
    
    private void mostrarAlerta(String tipo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(tipo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    private boolean validaIncidencia() {
        boolean camposValidos = true;
        TipoBusqueda seleccion = cmbBuscarIncidente.getSelectionModel().getSelectedItem();

        if (seleccion == null) {
            camposValidos = false;
            mostrarAlerta("Error", "Por favor, seleccione un tipo de búsqueda.");
        } else if (seleccion.getId() != 1 && txtBusquedaIncidente.getText().trim().isEmpty()) {
            camposValidos = false;
            mostrarAlerta("Error", "Por favor, complete el campo de búsqueda.");
        }

        return camposValidos;
    }

    private void habilitarCampos() {
        TipoBusqueda seleccion = cmbBuscarIncidente.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
        	 if (seleccion.getId() == EnumTipoBusqueda.TODOS.getId()) {
                txtBusquedaIncidente.setDisable(true);
            } else {
                txtBusquedaIncidente.setDisable(false);
            }
        }
    }



	public void limpiarCampos() {
		  cmbBuscarIncidente.getSelectionModel().clearSelection();
		  txtBusquedaIncidente.clear();

		}
    
	public void buscarPorFiltroIncidencia() {
    	
    	if(validaIncidencia()) {
    		 IIncidencia incidenciaDao = new IncidenciaDaoImpl();
    		 incidenciaData.clear(); // Elimina todos los elementos existentes en la lista
    	     incidenciaData.addAll(incidenciaDao.busquedaTotalIncidencias());
    	     //habilitarCampos();
    	}
    	
    }

}
