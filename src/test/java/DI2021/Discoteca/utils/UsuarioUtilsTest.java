/**
 * 
 */
package DI2021.Discoteca.utils;

import org.junit.Test;
import org.junit.Assert;


/**
 * @author darioaxel
 *
 */
public class UsuarioUtilsTest {

	@Test
	public void Funciona() {
		Assert.assertTrue(UsuarioUtils.ValidarCalidadPassword("pass67wword"));
	}
	@Test
	public void Nofunciona() {
		Assert.assertFalse(UsuarioUtils.ValidarCalidadPassword("passw"));
	}

}
