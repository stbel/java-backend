package backend.core.servico.servicoVenda.bean;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ServicoVendaDao extends Dao<ServicoVendaBean> {
	@Override
	public List<ServicoVendaBean> search(String term) {
		return list();

	}
}