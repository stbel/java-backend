package backend.core.cadastro.fornecedor.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class FornecedorDao extends Dao<FornecedorBean>{

	@Override
	public List<FornecedorBean> search(String term) {

		return list();
	}
}