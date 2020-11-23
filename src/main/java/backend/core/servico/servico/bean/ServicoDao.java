package backend.core.servico.servico.bean;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ServicoDao extends Dao<ServicoBean> {
	@Override
	public List<ServicoBean> search(String term) {
		return list();

	}
}