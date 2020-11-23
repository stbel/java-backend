package backend.core.estoque.pedidoItem.rule;

import java.math.BigDecimal;

import backend.core.estoque.pedidoItem.data.PedidoItemBean;
import backend.core.estoque.pedidoItem.data.PedidoItemDao;
import backend.core.frame.jpa.Rule;

public class PedidoItemRule extends Rule<PedidoItemBean, PedidoItemDao> {
	
	public BigDecimal totalSemDesconto(PedidoItemBean bean) {
		BigDecimal total = BigDecimal.ZERO;
		
		BigDecimal qtd = BigDecimal.valueOf(bean.getQuantidade());
		BigDecimal preco = bean.getPrecoUnidade();
		
		total = preco.multiply(qtd);
		
		return total;
		
	}

	public BigDecimal totalComDesconto(PedidoItemBean bean) {

		BigDecimal total = BigDecimal.ZERO;
		BigDecimal cem = BigDecimal.valueOf(100);
		
		BigDecimal semDesconto = totalSemDesconto(bean);
		
		BigDecimal descconto = BigDecimal.valueOf(bean.getDescontoNegocial());
		BigDecimal remanescente = cem.subtract(descconto);
		
		total = semDesconto.multiply(remanescente).divide(cem);
		
		return total;
	}
}
