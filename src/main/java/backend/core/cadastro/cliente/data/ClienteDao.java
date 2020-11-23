package backend.core.cadastro.cliente.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class ClienteDao extends Dao<ClienteBean>{

	@Override
	public List<ClienteBean> search(String term) {

		return list();
	}
}