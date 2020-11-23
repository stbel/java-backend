package backend.core.estoque.pedido.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import backend.core.frame.jpa.Dao;

public class PedidoDao extends Dao<PedidoBean> {

	@Override
	public List<PedidoBean> search(String term) {

		return list();

	}

	public List<PedidoBean> pedidos(String term, PedidoTipo tipo) {

		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("tipo", tipo));
		c.addOrder(Order.desc("data"));
		
		@SuppressWarnings("unchecked")
		List<PedidoBean> list = c.list();
		s.close();
		return list;
	}
	
	public List<PedidoBean> sales(String term) {

		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("tipo", PedidoTipo.VENDA));
		c.addOrder(Order.desc("data"));
		
		@SuppressWarnings("unchecked")
		List<PedidoBean> list = c.list();
		s.close();
		return list;
	}

	public List<PedidoBean> purchases(String term) {

		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("tipo", PedidoTipo.COMPRA));
		c.addOrder(Order.desc("data"));
		
		@SuppressWarnings("unchecked")
		List<PedidoBean> list = c.list();
		s.close();
		return list;
	}

	public void fechaPedido(PedidoBean bean) {

		bean.setStatus(PedidoStatus.FECHADO);
		update(bean);

	}
}