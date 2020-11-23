package backend.core.cadastro.pessoa.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class PessoaDao extends Dao<PessoaBean>{

	@Override
	public List<PessoaBean> search(String term) {
		info("Lista pessoas");
		return list();
	}
}