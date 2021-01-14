package DI2021.Discoteca;

import java.util.List;

import DI2021.Discoteca.dao.IDAO;
import DI2021.Discoteca.models.Album;
import DI2021.Discoteca.models.Usuario;
import DI2021.Discoteca.services.AlbumRecoveryService;
import DI2021.Discoteca.services.UsuarioRecoveryService;
import DI2021.Discoteca.utils.UsuarioUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Ejemplo Básico de recuperación de datos");
		List<Album> myAlbums = AlbumRecoveryService.getAllAlbums();
		for (var album : myAlbums) {
			System.out.println(album);
		}

		List<Usuario> usuarios = UsuarioRecoveryService.getAllUsuarios();
		for (var user : usuarios) {
			System.out.println(user);

		}
		System.out.println();
		IDAO idao = new IDAO(UsuarioRecoveryService.getAllUsuarios());
		List<Usuario> usuar = idao.getAll();
		for (Usuario usuario : usuar) {
			System.out.println(usuario);
		}

		System.out.println();
		String password = "platano1";
		UsuarioUtils.ValidarCalidadPassword(password);

	}
}
