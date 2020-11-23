package backend.core.estoque.produtoVariacao.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProdutoVariacaoDao extends Dao<ProdutoVariacaoBean>{

	@Override
	public List<ProdutoVariacaoBean> search(String term) {

		return list();
	}
}