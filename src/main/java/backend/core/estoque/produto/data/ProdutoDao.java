package backend.core.estoque.produto.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import backend.core.estoque.estoque.bean.EstoqueBean;
import backend.core.estoque.estoque.bean.EstoqueDao;
import backend.core.estoque.precoVenda.data.PrecoVendaBean;
import backend.core.estoque.precoVenda.data.PrecoVendaDao;
import backend.core.frame.jpa.Dao;

public class ProdutoDao extends Dao<ProdutoBean> {

	@Override
	public ProdutoBean update(ProdutoBean t) {

		ProdutoBean product = super.update(t);

		EstoqueDao iDao = new EstoqueDao();
		EstoqueBean inventory = iDao.find(product);
		if (inventory == null) {
			iDao.openInventory(product);
		}

		PrecoVendaDao sDao = new PrecoVendaDao();
		PrecoVendaBean salePrice = sDao.find(product);
		if (salePrice == null) {
			sDao.openPrice(product);
		}

		return product;
	}

	@Override
	public List<ProdutoBean> search(String term) {
		Session s = session();
		Criteria c = distinctBeanCriteria(s);
		c.add(Restrictions.ilike("name", term, MatchMode.ANYWHERE));
		
		@SuppressWarnings("unchecked")
		List<ProdutoBean> list = c.list();
		s.close();
		
		return list;
	}

	
}