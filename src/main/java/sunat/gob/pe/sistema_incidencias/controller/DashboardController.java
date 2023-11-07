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
          //inicializarPieChart();
       
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
     
    public void retornaBusqueda(ActionEvent actionEvent) throws IOException {
         
          FXMLLoader loader =  App.getFXMLLoader("busquedaAirbn");
            Parent busquedaAirbn = loader.load();
            App.scene.setRoot(busquedaAirbn);
               Window window = App.scene.getWindow();
            window.setWidth(900);
            window.setHeight(700);
    }
    public void inicializarPieChart() {
        // Crear los datos para el PieChart
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Categoría A", 30),
                        new PieChart.Data("Categoría B", 20),
                        new PieChart.Data("Categoría C", 50)
                );

        // Asignar los datos al PieChart
        pieChart.setData(pieChartData);
        pieChart.setTitle("Ejemplo de PieChart");
    }
    
}
