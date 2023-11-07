package sunat.gob.pe.sistema_incidencias.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
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
    private Label lblTotalIncidencias;

    @FXML
    private Label lblTotalUsuarios;

    @FXML
	private Label lblTotalUrgencias;

	@FXML
	private Label lblIncidenciaMax;
	
    @FXML
    private BarChart<String, Number> barChart;
    
    @FXML
    private PieChart pieChart;
    
    @FXML
    private CategoryAxis xAxis;
    
    @FXML
    private NumberAxis yAxis;
    
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    
    private Igrafico graficoDao = new graficoDaoImpl();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          llenarGrafico();
          llenarLabels();  
    }    
    
     public void llenarGrafico()
     {  
       List<barra> barras = graficoDao.grafico1();
         
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Cantidad por Incidencias");
        for (barra barra : barras) {
            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(barra.getTexto(), barra.getValor());
            series.getData().add(dataPoint); 
            
                  dataPoint.nodeProperty().addListener((observable, oldNode, newNode) -> {
                if (newNode != null) {
                    displayLabelForData(dataPoint);
                }
            });
            // Agregar también al PieChart
            PieChart.Data pieData = new PieChart.Data(barra.getTexto(), barra.getValor());
            pieChartData.add(pieData);
            
        }

        barChart.getData().add(series);
        pieChart.setTitle("Cantidad de Incidencias");
        pieChart.setData(pieChartData); // Actualizar datos en el PieChart

        
     }
     
     private void displayLabelForData(XYChart.Data<String, Number> data) {
        StackPane node = (StackPane) data.getNode();
        String value = String.valueOf(data.getYValue());
        Label dataLabel = new Label(value);
        node.getChildren().add(dataLabel);
    }
     
     public void llenarLabels() {
         // Aquí puedes realizar cualquier cálculo o acceder a tus datos para obtener los valores reales
         String totalIncidencias = "100";  // Cambia esto con el valor real
         String totalUsuarios = "25";   // Cambia esto con el valor real
         String totalUrgencias = "6";    // Cambia esto con el valor real
         String incidenciaMax = "HOla";      // Cambia esto con el valor real

         lblTotalIncidencias.setText(totalIncidencias);
         lblTotalUsuarios.setText(totalUsuarios);
         lblTotalUrgencias.setText(totalUrgencias);
         lblIncidenciaMax.setText(incidenciaMax);
     }
}
