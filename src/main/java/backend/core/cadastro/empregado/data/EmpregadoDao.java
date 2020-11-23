package backend.core.cadastro.empregado.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class EmpregadoDao extends Dao<EmpregadoBean>{

	@Override
	public List<EmpregadoBean> search(String term) {

		return list();
	}
}