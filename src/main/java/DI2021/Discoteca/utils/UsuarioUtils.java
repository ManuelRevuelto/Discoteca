package DI2021.Discoteca.utils;

public class UsuarioUtils {

	public static boolean ValidarCalidadPassword(String password) {

		boolean bool = false;
		int caracterASCII, z = 0;
		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				caracterASCII = password.charAt(i);
				if (caracterASCII > 47 && caracterASCII < 58) {
					z++;
				}
			}
			if (z > 0) {
				bool = true;
				System.out.println("La contraseña es correcta");
			}
		} else {
			System.out.println("La contraseña no es lo suficientemente fuerte");
		}

		return bool;
	
	}
}
