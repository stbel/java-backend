package backend.core.estoque.produtoVariacaoTipo.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProdutoVariacaoTipoDao extends Dao<ProdutoVariacaoTipoBean> {

	@Override
	public List<ProdutoVariacaoTipoBean> search(String term) {

		return list();

	}
}