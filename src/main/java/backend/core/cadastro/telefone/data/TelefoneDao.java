package backend.core.cadastro.telefone.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class TelefoneDao extends Dao<TelefoneBean>{

	@Override
	public List<TelefoneBean> search(String term) {

		return list();
	}
}