package backend.core.financeiro.formaPagamento.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class FormaPagamentoDao extends Dao<FormaPagamentoBean> {

	@Override
	public List<FormaPagamentoBean> search(String term) {

		return list();

	}
}