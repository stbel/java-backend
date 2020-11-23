package backend.core.estoque.pedidoItem.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import backend.core.estoque.pedido.data.PedidoTipo;
import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.Dao;

public class PedidoItemDao extends Dao<PedidoItemBean> {

	@Override
	public List<PedidoItemBean> search(String term) {

		return list();

	}

	public BigDecimal medianCost(ProdutoBean product) {

		String qCompra = "select pi.quantidade, pi.precounidade, pi.descontonegocial from pedido_itens pi join produtos pr on pr.id = pi.produto_id join pedidos pe on pe.id = pi.pedido_id where pr.id = "
				+ product.getId() + " and pe.tipo = '" + PedidoTipo.COMPRA + "' and pe.status = 'FECHADO' order by pe.data";

		String qVenda = "select pi.quantidade, pi.precounidade, pi.descontonegocial from pedido_itens pi join produtos pr on pr.id = pi.produto_id join pedidos pe on pe.id = pi.pedido_id where pr.id = "
				+ product.getId() + " and pe.tipo = '" + PedidoTipo.VENDA + "' and pe.status = 'FECHADO' order by pe.data";

		BigDecimal mediaCost = BigDecimal.ZERO;
		Session s = session();

		SQLQuery sqlCompra = s.createSQLQuery(qCompra);
		SQLQuery sqlVenda = s.createSQLQuery(qVenda);

		@SuppressWarnings("unchecked")
		List<Object[]> listCompra = sqlCompra.list();
		@SuppressWarnings("unchecked")
		List<Object[]> listVenda = sqlVenda.list();

		List<BigDecimal> precosCompras = new ArrayList<BigDecimal>();

		for (Object[] data : listCompra) {
			int qtd = (int) data[0];
			for (int i = 0; i < qtd; i++) {
				BigDecimal preco = (BigDecimal) data[1];
				BigDecimal rem = BigDecimal.valueOf((100 - (int) data[2]), 2);

				precosCompras.add(preco.multiply(rem));
			}
		}

		List<BigDecimal> precosVendas = new ArrayList<BigDecimal>();

		for (Object[] data : listVenda) {
			int qtd = (int) data[0];
			for (int i = 0; i < qtd; i++) {

				BigDecimal preco = (BigDecimal) data[1];
				BigDecimal rem = BigDecimal.valueOf((100 - (int) data[2]), 2);

				precosVendas.add(preco.multiply(rem));

			}
		}

		if (precosCompras.size() > precosVendas.size()) {
			List<BigDecimal> rem = precosCompras.subList(precosVendas.size(), precosCompras.size());
			for (BigDecimal bigDecimal : rem) {
				mediaCost = mediaCost.add(bigDecimal);
			}
			mediaCost = mediaCost.divide(BigDecimal.valueOf(rem.size()), RoundingMode.HALF_EVEN);
		} else {
			if (precosCompras.size() == 0) {
				mediaCost = BigDecimal.ZERO;
			} else {

				mediaCost = precosCompras.get(precosCompras.size() - 1);
			}
		}

		// Criteria cPurchase = s.createCriteria(getBeanClass());
		// cPurchase.add(Restrictions.eq("produto", product));
		// Criteria cPurchaseOrder = cPurchase.createCriteria("pedido");
		// cPurchaseOrder.add(Restrictions.eq("tipo", PedidoTipo.COMPRA));
		// cPurchaseOrder.add(Restrictions.eq("status", PedidoStatus.FECHADO));
		//
		// Criteria cSale = s.createCriteria(getBeanClass());
		// cSale.add(Restrictions.eq("produto", product));
		// Criteria cSaleOrder = cSale.createCriteria("pedido");
		// cSaleOrder.add(Restrictions.eq("tipo", PedidoTipo.VENDA));
		// cSaleOrder.add(Restrictions.eq("status", PedidoStatus.FECHADO));
		//
		// @SuppressWarnings("unchecked")
		// List<PedidoItemBean> purchases = cPurchase.list();
		// List<BigDecimal> purchasePrices = new ArrayList<BigDecimal>();
		//
		// for (PedidoItemBean orderItemBean : purchases) {
		// for (int i = 0; i < orderItemBean.getQuantidade(); i++) {
		// purchasePrices.add(orderItemBean.getPrecoUnidade());
		// }
		// }
		//
		// @SuppressWarnings("unchecked")
		// List<PedidoItemBean> sales = cSale.list();
		// List<BigDecimal> salePrices = new ArrayList<BigDecimal>();
		//
		// for (PedidoItemBean orderItemBean : sales) {
		// for (int i = 0; i < orderItemBean.getQuantidade(); i++) {
		// salePrices.add(orderItemBean.getPrecoUnidade());
		// }
		// }
		//
		// if (purchasePrices.size() > salePrices.size()) {
		// List<BigDecimal> rem = purchasePrices.subList(salePrices.size(),
		// purchasePrices.size());
		// for (BigDecimal bigDecimal : rem) {
		// mediaCost = mediaCost.add(bigDecimal);
		// }
		// mediaCost = mediaCost.divide(BigDecimal.valueOf(rem.size()),
		// RoundingMode.HALF_EVEN);
		// } else {
		// if (purchasePrices.size() == 0) {
		// mediaCost = BigDecimal.ZERO;
		// } else {
		//
		// mediaCost = purchasePrices.get(purchasePrices.size() - 1);
		// }
		// }

		s.close();
		releaseEm();
		return mediaCost;
	}
}