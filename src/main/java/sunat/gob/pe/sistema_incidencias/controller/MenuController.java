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
    private void abrirProdutos() {
        abrir("/com/jdenner/view/Produto.fxml", "Produtos");
    }
   
    @FXML
    private void abrirClientes() {
        abrir("/com/jdenner/view/Cliente.fxml", "Clientes");
    }
    
    @FXML
    private void abrirFornecedores() {
        abrir("/com/jdenner/view/Fornecedor.fxml", "Fornecedores");
    }
    
    @FXML
    private void abrirCompras() {
        abrir("/com/jdenner/view/Compra.fxml", "Compras");
    }

    @FXML
    private void abrirVendas() {
        abrir("/com/jdenner/view/Venda.fxml", "Vendas");
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
