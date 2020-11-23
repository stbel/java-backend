package backend.core.financeiro.pagamento.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class PagamentoDao extends Dao<PagamentoBean> {

	@Override
	public List<PagamentoBean> search(String term) {

		return list();

	}
		
}