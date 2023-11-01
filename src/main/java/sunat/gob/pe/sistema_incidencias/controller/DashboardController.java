package sunat.gob.pe.sistema_incidencias.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Window;
import sunat.gob.pe.sistema_incidencias.App;
import sunat.gob.pe.sistema_incidencias.model.dao.Igrafico;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.graficoDaoImpl;
import sunat.gob.pe.sistema_incidencias.model.entities.barra;

public class DashboardController implements Initializable {
 @FXML
    private BarChart<String, Number> barChart;
    
    @FXML
    private CategoryAxis xAxis;
    
    @FXML
    private NumberAxis yAxis;
    
     private Igrafico graficoDao = new graficoDaoImpl();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          llenarGrafico();
       
    }    
    
     public void llenarGrafico()
     {  
     /*    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("2023");
        series1.getData().add(new XYChart.Data<>("January", 200));
        series1.getData().add(new XYChart.Data<>("February", 275));

        barChart.getData().addAll(series1);}
     */
       List<barra> barras = graficoDao.grafico1();
         
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Cantidad por Usuario");
        for (barra barra : barras) {
            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(barra.getTexto(), barra.getValor());
            series.getData().add(dataPoint); 
            
                  dataPoint.nodeProperty().addListener((observable, oldNode, newNode) -> {
                if (newNode != null) {
                    displayLabelForData(dataPoint);
                }
            });
            
        }

        barChart.getData().add(series);

        
     }
     
     private void displayLabelForData(XYChart.Data<String, Number> data) {
        StackPane node = (StackPane) data.getNode();
        String value = String.valueOf(data.getYValue());
        Label dataLabel = new Label(value);
        node.getChildren().add(dataLabel);
    }
     
    public void retornaBusqueda(ActionEvent actionEvent) throws IOException {
         
          FXMLLoader loader =  App.getFXMLLoader("busquedaAirbn");
            Parent busquedaAirbn = loader.load();
            App.scene.setRoot(busquedaAirbn);
               Window window = App.scene.getWindow();
            window.setWidth(900);
            window.setHeight(700);
    }
    
}
