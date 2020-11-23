package backend.core.estoque.producaoExecucao.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ProducaoExecucaoDao extends Dao<ProducaoExecucaoBean> {
	@Override
	public List<ProducaoExecucaoBean> search(String term) {
		return list();

	}
}