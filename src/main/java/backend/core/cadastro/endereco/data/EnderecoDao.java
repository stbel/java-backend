package backend.core.cadastro.endereco.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class EnderecoDao extends Dao<EnderecoBean>{

	@Override
	public List<EnderecoBean> search(String term) {

		return list();
	}
}