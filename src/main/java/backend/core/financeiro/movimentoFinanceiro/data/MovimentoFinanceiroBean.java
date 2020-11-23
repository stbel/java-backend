package backend.core.financeiro.movimentoFinanceiro.data;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.financeiro.contaFinanceira.data.ContaFinanceiraBean;
import backend.core.financeiro.lancamentoFinanceiro.data.LancamentoFinanceiroBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "financeiro_movimentos")
public class MovimentoFinanceiroBean extends Bean {

	private ContaFinanceiraBean conta;

	private LancamentoFinanceiroBean lancamento;

	private MovimentoFinanceiroTipo tipo;

	private BigDecimal valor;

	private LocalDate data;

	@ManyToOne
	public ContaFinanceiraBean getConta() {
		return conta;
	}

	public void setConta(ContaFinanceiraBean conta) {
		this.conta = conta;
	}

	@Enumerated(EnumType.STRING)
	public MovimentoFinanceiroTipo getTipo() {
		return tipo;
	}

	public void setTipo(MovimentoFinanceiroTipo tipo) {
		this.tipo = tipo;
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

	@OneToOne
	public LancamentoFinanceiroBean getLancamento() {
		return lancamento;
	}

	public void setLancamento(LancamentoFinanceiroBean lancamento) {
		this.lancamento = lancamento;
	}
}