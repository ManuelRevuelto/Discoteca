package DI2021.Discoteca.dao;

import java.util.ArrayList;
import java.util.List;

import DI2021.Discoteca.models.Album;
import DI2021.Discoteca.services.AlbumRecoveryService;

public class AlbumDAO implements DAO<Album> {
	List<Album> misAlbums = new ArrayList<Album>();

	public AlbumDAO(List<Album> misAlbums) {
		this.misAlbums = misAlbums;
	}

	@Override
	public Album get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Album t) {
		if (!misAlbums.contains(t) && misAlbums.add(t)) {
			AlbumRecoveryService.saveAlbums(misAlbums);
		}
	}

	@Override
	public void update(Album t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Album t) {
		// TODO Auto-generated method stub

	}

}
