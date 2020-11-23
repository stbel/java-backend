package backend.core.cadastro.redeSocialPerfil.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class RedeSocialPerfilDao extends Dao<RedeSocialPerfilBean>{

	@Override
	public List<RedeSocialPerfilBean> search(String term) {

		return list();
	}
}