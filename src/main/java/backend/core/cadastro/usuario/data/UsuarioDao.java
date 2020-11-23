package backend.core.cadastro.usuario.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import backend.core.frame.jpa.Dao;

public class UsuarioDao extends Dao<UsuarioBean> {
	@Override
	public List<UsuarioBean> search(String term) {
		
		return list();
	}

	public UsuarioBean findUsuario(String usuario) {
		
		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("usuario", usuario));
		
		@SuppressWarnings("unchecked")
		List<UsuarioBean> list = c.list();
		
		if(list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
	}
}