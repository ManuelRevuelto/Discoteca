package DI2021.Discoteca.dao;

import java.util.ArrayList;
import java.util.List;

import DI2021.Discoteca.models.Usuario;

public class IDAO implements DAO<Usuario> {
	List<Usuario> misUsuarios = new ArrayList<Usuario>();

	public IDAO(List<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	@Override
	public Usuario get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAll() {
		return misUsuarios;
	}

	@Override
	public void save(Usuario t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Usuario t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Usuario t) {
		// TODO Auto-generated method stub

	}

}
