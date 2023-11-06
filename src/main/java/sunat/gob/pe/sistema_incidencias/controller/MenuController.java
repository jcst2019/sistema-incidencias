package sunat.gob.pe.sistema_incidencias.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sunat.gob.pe.sistema_incidencias.App;

public class MenuController implements Initializable {

    @FXML
    private TabPane tabPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    @FXML
    private void abrirDashboard() {
        abrir("dashboard", "Dasboard");
    }
    @FXML
    private void abrirRegistroIncidencia() {
        abrir("registroIncidencia", "Registro Incidencia");
    }
    
    @FXML
    private void buscarIncidencia() {
        abrir("buscarIncidencia", "Buscar Incidencia");
    }
    
  
    @FXML
    private void abrirCreditos() {
        abrir("acercaDe", "Acerca De");
    }
    
    private void abrir(String fxml, String title) {
        try {
            //FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            FXMLLoader loader = new  FXMLLoader(App.class.getResource(fxml + ".fxml"));      
            Parent content = loader.load();
            Tab tab = new Tab(title);
            tab.setContent(content);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
