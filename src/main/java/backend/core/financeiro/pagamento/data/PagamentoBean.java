package backend.core.financeiro.pagamento.data;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import backend.core.estoque.pedido.data.PedidoBean;
import backend.core.financeiro.lancamentoFinanceiro.data.LancamentoFinanceiroBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "financeiro_pagamentos")
public class PagamentoBean extends Bean {

	private PedidoBean pedido;

	private List<LancamentoFinanceiroBean> parcelas;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<LancamentoFinanceiroBean> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<LancamentoFinanceiroBean> parcelas) {
		this.parcelas = parcelas;
	}

	@OneToOne
	public PedidoBean getPedido() {
		return pedido;
	}

	public void setPedido(PedidoBean pedido) {
		this.pedido = pedido;
	}

	@Transient
	public BigDecimal total() {
		BigDecimal total = BigDecimal.ZERO;
		for (LancamentoFinanceiroBean l : parcelas) {
			total = total.add(l.getValor());
		}
		return total;
	}
}