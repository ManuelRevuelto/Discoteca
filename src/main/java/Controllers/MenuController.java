package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
	@FXML
	Button clientBtn;
	@FXML
	Button orderBtn;

	@FXML
	public void goToClient(ActionEvent actionEvent) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Album.fxml"));
		Parent root = loader.load();
		AlbumController controladorC = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(a -> controladorC.closeWindowsCliente());
		Stage mystage = (Stage) this.clientBtn.getScene().getWindow();
		mystage.close();

	}

	@FXML
	public void goToOrder(ActionEvent actionEvent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Usuario.fxml"));
		Parent root = loader.load();
		UsuarioController controladorP = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(ac -> controladorP.closeWindowsPedido());
		Stage mystage = (Stage) this.orderBtn.getScene().getWindow();
		mystage.close();
	}

	public void closeWindowsMenu() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			Stage mystage = (Stage) this.clientBtn.getScene().getWindow();
			mystage.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
