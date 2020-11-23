package backend.core.financeiro.lancamentoFinanceiro.data;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.financeiro.formaPagamento.data.FormaPagamentoBean;
import backend.core.financeiro.movimentoFinanceiro.data.MovimentoFinanceiroBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "financeiro_lancamentos")
public class LancamentoFinanceiroBean extends NamedBean {

	private FormaPagamentoBean formaPagamento;

	private LocalDate data;

	private BigDecimal valor;

	private LancamentoFinanceiroStatus status;
	
	private LancamentoFinanceiroTipo tipo;
	
	private MovimentoFinanceiroBean movimento;

	@ManyToOne
	public FormaPagamentoBean getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoBean formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Enumerated(EnumType.STRING)
	public LancamentoFinanceiroStatus getStatus() {
		return status;
	}

	public void setStatus(LancamentoFinanceiroStatus status) {
		this.status = status;
	}
	
	@Enumerated(EnumType.STRING)
	public LancamentoFinanceiroTipo getTipo() {
		return tipo;
	}

	public void setTipo(LancamentoFinanceiroTipo tipo) {
		this.tipo = tipo;
	}

	@OneToOne
	public MovimentoFinanceiroBean getMovimento() {
		return movimento;
	}

	public void setMovimento(MovimentoFinanceiroBean movimento) {
		this.movimento = movimento;
	}
}