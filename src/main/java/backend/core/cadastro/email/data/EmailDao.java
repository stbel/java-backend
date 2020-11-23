package backend.core.cadastro.email.data;

import java.util.List;

import backend.core.frame.jpa.Dao;

public class EmailDao extends Dao<EmailBean>{

	@Override
	public List<EmailBean> search(String term) {

		return list();
	}
}