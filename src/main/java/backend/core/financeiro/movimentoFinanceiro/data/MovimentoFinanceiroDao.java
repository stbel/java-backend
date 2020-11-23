package backend.core.financeiro.movimentoFinanceiro.data;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import backend.core.financeiro.contaFinanceira.data.ContaFinanceiraBean;
import backend.core.financeiro.lancamentoFinanceiro.data.LancamentoFinanceiroTipo;
import backend.core.frame.jpa.Dao;

public class MovimentoFinanceiroDao extends Dao<MovimentoFinanceiroBean> {
	@Override
	public List<MovimentoFinanceiroBean> search(String term) {
		return list();

	}
	
	public BigDecimal saldo(ContaFinanceiraBean conta){
		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("conta", conta));
		
		Criteria entrada = c.setProjection(Projections.sum("valor"));
		entrada.add(Restrictions.eq("tipo", LancamentoFinanceiroTipo.ENTRADA));
				
		BigDecimal entradas = (BigDecimal) c.uniqueResult();
		
		c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("conta", conta));
		
		Criteria saida = c.setProjection(Projections.sum("valor"));
		saida.add(Restrictions.eq("tipo", LancamentoFinanceiroTipo.SAIDA));
				
		BigDecimal saidas = (BigDecimal) c.uniqueResult();
		
		s.close();
		
		entradas = entradas == null ? BigDecimal.ZERO : entradas;
		saidas = saidas == null ? BigDecimal.ZERO : saidas;
		
		return entradas.subtract(saidas);
	}

	public List<MovimentoFinanceiroBean> fluxo(ContaFinanceiraBean conta) {
		
		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("conta", conta));
		c.addOrder(Order.desc("data"));
		@SuppressWarnings("unchecked")
		List<MovimentoFinanceiroBean> list = c.list();
		s.close();
		return list;
	}
}