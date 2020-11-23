package backend.core.estoque.estoque.bean;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import backend.core.estoque.pedido.data.PedidoBean;
import backend.core.estoque.pedidoItem.data.PedidoItemBean;
import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.Dao;

public class EstoqueDao extends Dao<EstoqueBean> {

	@Override
	public List<EstoqueBean> search(String term) {

		return list();

	}

	public EstoqueBean find(ProdutoBean product) {

		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("produto", product));
		EstoqueBean result = (EstoqueBean) c.uniqueResult();
		s.close();
		releaseEm();
		return result;
	}

	public void openInventory(ProdutoBean product) {

		EstoqueBean bean = new EstoqueBean();
		bean.setQuantidade(0);
		bean.setProduto(product);
		update(bean);
	}

	public void movimentaVenda(PedidoBean bean) {

		for (PedidoItemBean item : bean.getItens()) {
			EstoqueBean inv = find(item.getProduto());
			inv.setQuantidade(inv.getQuantidade() - item.getQuantidade());
			update(inv);
		}

	}

	public void movimentaCompra(PedidoBean bean) {

		for (PedidoItemBean item : bean.getItens()) {
			EstoqueBean inv = find(item.getProduto());
			inv.setQuantidade(inv.getQuantidade() + item.getQuantidade());
			update(inv);
		}
	}
}