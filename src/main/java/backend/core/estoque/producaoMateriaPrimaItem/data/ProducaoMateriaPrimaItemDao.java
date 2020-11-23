package backend.core.estoque.producaoMateriaPrimaItem.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProducaoMateriaPrimaItemDao extends Dao<ProducaoMateriaPrimaItemBean> {
	@Override
	public List<ProducaoMateriaPrimaItemBean> search(String term) {
		return list();

	}
}