package backend.core.estoque.unidadeMedida.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class UnidadeMedidaDao extends Dao<UnidadeMedidaBean>{

	@Override
	public List<UnidadeMedidaBean> search(String term) {

		return list();
	}
}