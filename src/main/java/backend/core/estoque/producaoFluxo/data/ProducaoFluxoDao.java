package backend.core.estoque.producaoFluxo.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProducaoFluxoDao extends Dao<ProducaoFluxoBean> {
	@Override
	public List<ProducaoFluxoBean> search(String term) {
		return list();

	}
}