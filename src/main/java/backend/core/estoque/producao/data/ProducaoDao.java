package backend.core.estoque.producao.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProducaoDao extends Dao<ProducaoBean> {
	@Override
	public List<ProducaoBean> search(String term) {
		return list();

	}
}