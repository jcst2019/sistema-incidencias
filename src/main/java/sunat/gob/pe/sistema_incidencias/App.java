package sunat.gob.pe.sistema_incidencias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	public static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent login = App.loadFXML("login");
            scene = new Scene(login);
            stage.setScene(scene);
            stage.setTitle("Sistema de Incidencias");
            stage.centerOnScreen();
            stage.show();
        }catch(IOException ie){
            System.out.println(ie.getMessage());
            System.out.println(ie.getCause());
            
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static FXMLLoader getFXMLLoader(String fxml) throws IOException {
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));        
    }

    public static void main(String[] args) {
        launch();
    }

}