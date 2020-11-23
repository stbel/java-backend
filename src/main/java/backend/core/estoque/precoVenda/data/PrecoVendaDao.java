package backend.core.estoque.precoVenda.data;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.Dao;

public class PrecoVendaDao extends Dao<PrecoVendaBean> {

	@Override
	public List<PrecoVendaBean> search(String term) {

		return list();

	}

	public PrecoVendaBean find(ProdutoBean product) {
		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("produto", product));
		PrecoVendaBean result = (PrecoVendaBean) c.uniqueResult();
		s.close();
		return result;
	}

	public void openPrice(ProdutoBean product) {

		PrecoVendaBean bean = new PrecoVendaBean();
		bean.setProduto(product);
		bean.setValorBase(BigDecimal.ZERO);
		update(bean);
	}
}