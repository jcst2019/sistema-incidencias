package sunat.gob.pe.sistema_incidencias.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import sunat.gob.pe.sistema_incidencias.App;
import sunat.gob.pe.sistema_incidencias.model.dao.IUsuarioDao;
import sunat.gob.pe.sistema_incidencias.model.dao.impl.UsuarioDaoImpl;
import sunat.gob.pe.sistema_incidencias.model.entities.Usuario;
import sunat.gob.pe.sistema_incidencias.model.entities.UsuarioGlobal;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtClave;

    @FXML
    public void autenticarUsuario(ActionEvent actionEvent) throws IOException {
        System.out.println(txtUsuario.getText().trim());
        System.out.println(txtClave.getText());

        if ("".equals(txtUsuario.getText().trim())) {
            mostrarAlertas("Warning", "Ingrese Usuario", Alert.AlertType.WARNING);
            return;
        }
        
        if ("".equals(txtClave.getText().trim())) {
            mostrarAlertas("Warning", "Ingrese Clave", Alert.AlertType.WARNING);
            return;
        }

        IUsuarioDao usuariodao = new UsuarioDaoImpl();
        Map<Integer, Object> mapUsuario = usuariodao.validarUsuario(txtUsuario.getText().trim(),
                 txtClave.getText());
        if (mapUsuario != null) {
            Iterator it = mapUsuario.keySet().iterator();
            while (it.hasNext()) {
                Integer key = (Integer) it.next();
                System.out.println("Clave: " + key + " -> Valor: " + mapUsuario.get(key));
                if (key != 4) {
                    mostrarAlertas("Warning", ""+mapUsuario.get(key), Alert.AlertType.WARNING);
                    return;
                }else {
                    Object value = mapUsuario.get(key);
                    if (value instanceof Usuario) {
                        Integer idUsuario = ((Usuario) value).getIdUsuario();
                        System.out.println("ID de Usuario: " + idUsuario);
                        UsuarioGlobal.setIdUsuario(idUsuario);
                    }
                }
            }
        }

        FXMLLoader loader = App.getFXMLLoader("menu");
        Parent busquedaAirbn = loader.load();
        App.scene.setRoot(busquedaAirbn);
        Window window = App.scene.getWindow();
        window.setWidth(1020);
        window.setHeight(700);

    }

    private void mostrarAlertas(String header, String content, Alert.AlertType type) {
        Alert dialogo = new Alert(type);
        dialogo.setHeaderText(header);
        dialogo.setContentText(content);
        dialogo.show();
    }

}
