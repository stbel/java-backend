package backend.core.estoque.producaoFase.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProducaoFaseDao extends Dao<ProducaoFaseBean> {
	@Override
	public List<ProducaoFaseBean> search(String term) {
		return list();

	}
}