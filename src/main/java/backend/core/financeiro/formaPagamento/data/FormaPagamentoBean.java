package backend.core.financeiro.formaPagamento.data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backend.core.financeiro.contaFinanceira.data.ContaFinanceiraBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "financeiro_formas_pagamento")
public class FormaPagamentoBean extends NamedBean {

	private Integer diasRealizar;

	private Boolean fechamentoAutomatico;

	private ContaFinanceiraBean destino;
	
	@Override
	public String toString() {

		return this.getName();
	}

	public Integer getDiasRealizar() {
		if (diasRealizar == null) {
			diasRealizar = 0;
		}
		return diasRealizar;
	}

	public void setDiasRealizar(Integer diasRealizar) {
		this.diasRealizar = diasRealizar;
	}

	public Boolean getFechamentoAutomatico() {
		if (fechamentoAutomatico == null) {
			fechamentoAutomatico = false;
		}
		return fechamentoAutomatico;
	}

	public void setFechamentoAutomatico(Boolean fechamentoAutomatico) {
		this.fechamentoAutomatico = fechamentoAutomatico;
	}

	@ManyToOne
	public ContaFinanceiraBean getDestino() {
		return destino;
	}

	public void setDestino(ContaFinanceiraBean destino) {
		this.destino = destino;
	}
}