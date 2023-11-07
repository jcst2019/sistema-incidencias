package sunat.gob.pe.sistema_incidencias.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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

         String totalIncidencias = graficoDao.obtenerTotalIncidencias();  
         String totalUsuarios = graficoDao.obtenerTotalUsuarios();   
         String totalUrgencias = graficoDao.obtenerTotalUrgencias();    
         String incidenciaMax = graficoDao.obtenerIncidenciaMaxima();     

         lblTotalIncidencias.setText(totalIncidencias);
         lblTotalUsuarios.setText(totalUsuarios);
         lblTotalUrgencias.setText(totalUrgencias);
         lblIncidenciaMax.setText(incidenciaMax);
     }
}
