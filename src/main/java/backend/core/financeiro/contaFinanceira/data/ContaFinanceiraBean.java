package backend.core.financeiro.contaFinanceira.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "financeiro_contas")
public class ContaFinanceiraBean extends NamedBean {
	
	@Override
	public String toString() {
		
		return getName();
	}
}