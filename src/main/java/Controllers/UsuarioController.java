package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DI2021.Discoteca.dao.IDAO;
import DI2021.Discoteca.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsuarioController {

	@FXML
	TextField textNombre, textEmail, textPass;
	@FXML
	Button crearPedidoBtn;

	static List<Usuario> misUsuarios = new ArrayList<Usuario>();
	static IDAO usuarioDao = new IDAO(misUsuarios);

	public Usuario createUsuario() {

		String nombre = textNombre.getText();
		String email = textEmail.getText();
		String pass = textPass.getText();

		Usuario u = new Usuario(nombre, email, pass);
		usuarioDao.save(u);
		return u;
	}

	@FXML
	public void crearUsuario(ActionEvent actionEvent) {
		Usuario p = null;
		p = createUsuario();
		usuarioDao.save(p);
		System.out.println(p.toString());

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(" MENSAJE ");
		alert.setContentText("PEDIDO AÑADIDO CORRECTAMENTE");
		alert.showAndWait();

	}

	@FXML
	public void borrarUsuario(ActionEvent actionEvent) {
		textNombre.setText("");
		textEmail.setText("");
		textPass.setText("");

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(" MENSAJE ");
		alert.setContentText("SE HAN BORRADO TODOS LOS DATOS");
		alert.showAndWait();

	}

	public void closeWindowsPedido() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
			Parent root = loader.load();
			MenuController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.closeWindowsMenu());
			Stage mystage = (Stage) this.crearPedidoBtn.getScene().getWindow();
			mystage.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
