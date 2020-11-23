package backend.core.financeiro.contaFinanceira.data;

import java.util.List;

import backend.core.frame.jpa.NamedDao;

public class ContaFinanceiraDao extends NamedDao<ContaFinanceiraBean> {
	@Override
	public List<ContaFinanceiraBean> search(String term) {
		return list();
	}
}