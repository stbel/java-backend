package backend.core.cadastro.redeSocial.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class RedeSocialDao extends Dao<RedeSocialBean>{

	@Override
	public List<RedeSocialBean> search(String term) {

		return list();
	}
}