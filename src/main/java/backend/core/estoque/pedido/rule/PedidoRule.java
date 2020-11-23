	package backend.core.estoque.pedido.rule;

import java.math.BigDecimal;

import backend.core.estoque.estoque.bean.EstoqueDao;
import backend.core.estoque.pedido.data.PedidoBean;
import backend.core.estoque.pedido.data.PedidoDao;
import backend.core.estoque.pedidoItem.data.PedidoItemBean;
import backend.core.estoque.pedidoItem.rule.PedidoItemRule;
import backend.core.financeiro.pagamento.data.PagamentoBean;
import backend.core.financeiro.pagamento.data.PagamentoDao;
import backend.core.frame.jpa.Rule;

public class PedidoRule extends Rule<PedidoBean, PedidoDao> {

	private PedidoItemRule itemRule = new PedidoItemRule();

	private EstoqueDao estoqueDao = new EstoqueDao();
	private PagamentoDao pagamentoDao = new PagamentoDao();

	public BigDecimal totalSemDesconto(PedidoBean bean) {
		BigDecimal total = BigDecimal.ZERO;

		for (PedidoItemBean item : bean.getItens()) {
			total = total.add(itemRule.totalSemDesconto(item));
		}

		return total;

	}

	public BigDecimal totalComDesconto(PedidoBean bean) {

		BigDecimal total = BigDecimal.ZERO;

		for (PedidoItemBean item : bean.getItens()) {
			total = total.add(itemRule.totalComDesconto(item));
		}

		return total;
	}

	public void fechamentoCompra(PedidoBean pedido, PagamentoBean pagamento) {

		estoqueDao.movimentaCompra(pedido);
		getDao().fechaPedido(pedido);

		pagamento.setPedido(pedido);
		pagamentoDao.update(pagamento);

	}

	public void fechamentoVenda(PedidoBean pedido, PagamentoBean pagamento) {
		
		estoqueDao.movimentaVenda(pedido);
		getDao().fechaPedido(pedido);

		pagamento.setPedido(pedido);
		pagamentoDao.update(pagamento);
	}
}
