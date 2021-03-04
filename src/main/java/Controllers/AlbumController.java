package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DI2021.Discoteca.dao.AlbumDAO;
import DI2021.Discoteca.models.Album;
import DI2021.Discoteca.models.Formato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AlbumController {
	@FXML
	TextField textArtista, textNombre, textAnno;
	@FXML
	RadioButton cd, vinilo, cassette;
	@FXML
	Button crearBtn;

	static List<Album> misAlbums = new ArrayList<Album>();
	static AlbumDAO albumDao = new AlbumDAO(misAlbums);

	public Album crearCliente() {

		String artista = textArtista.getText();
		String nombre = textNombre.getText();
		String anno = textAnno.getText();

		Formato f = cd.isSelected() ? Formato.CD : Formato.VINILO;
		Album c = null;
		if (!artista.equals("") || !nombre.equals("") || !anno.equals("")) {
			c = new Album(artista, nombre, anno, f);
			albumDao.save(c);
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle(" MENSAJE ");
			alert.setContentText("ES OBLIGATORIO RELLENAR TODOS LOS CAMPOS");
			alert.showAndWait();
		}
		return c;
	}

	@FXML
	public void crearAlbum(ActionEvent actionEvent) {
		Album c = null;
		c = crearCliente();

		System.out.println(c.toString());

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(" MENSAJE ");
		alert.setContentText("CLIENTE AÑADIDO CORRECTAMENTE");
		alert.showAndWait();
	}

	public void closeWindowsCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Menu.fxml"));
			Parent root = loader.load();
			MenuController controlador = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(e -> controlador.closeWindowsMenu());
			Stage mystage = (Stage) this.crearBtn.getScene().getWindow();
			mystage.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
