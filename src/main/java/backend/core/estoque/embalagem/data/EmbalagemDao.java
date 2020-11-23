package backend.core.estoque.embalagem.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class EmbalagemDao extends Dao<EmbalagemBean>{

	@Override
	public List<EmbalagemBean> search(String term) {

		return list();
	}
}