package backend.core.frame.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public abstract class NamedDao<B extends NamedBean> extends Dao<B> {

	public List<B> findByName(String name) {
		
		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("name", name));
		
		@SuppressWarnings("unchecked")
		List<B> list = c.list();
		s.close();
		return list;
	}
}
