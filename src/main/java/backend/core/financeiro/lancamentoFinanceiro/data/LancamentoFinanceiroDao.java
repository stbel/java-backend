package backend.core.financeiro.lancamentoFinanceiro.data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import backend.core.frame.jpa.Dao;

public class LancamentoFinanceiroDao extends Dao<LancamentoFinanceiroBean> {

	@Override
	public List<LancamentoFinanceiroBean> search(String term) {

		return list();
	}

	public List<LancamentoFinanceiroBean> correnteEmAberto(LocalDate dataConsulta, LancamentoFinanceiroTipo tipo) {

		LocalDate ultimoDia = LocalDate.of(dataConsulta.getYear(), dataConsulta.getMonth(), dataConsulta.lengthOfMonth());

		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.and(Restrictions.eq("status", LancamentoFinanceiroStatus.PENDENTE), Restrictions.eq("tipo", tipo), Restrictions.le("data", ultimoDia)));
		@SuppressWarnings("unchecked")
		List<LancamentoFinanceiroBean> list = c.list();
		s.close();

		return list;
	}
	
	public List<LancamentoFinanceiroBean> medioPrazo(LocalDate dataConsulta, LancamentoFinanceiroTipo tipo) {
		
		LocalDate inicio = LocalDate.of(dataConsulta.getYear(), dataConsulta.getMonth(), dataConsulta.lengthOfMonth());
		LocalDate fim = inicio.plus(6, ChronoUnit.MONTHS);
				
		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.and(Restrictions.eq("status", LancamentoFinanceiroStatus.PENDENTE), Restrictions.eq("tipo", tipo), Restrictions.gt("data", inicio), Restrictions.le("data", fim)));
		@SuppressWarnings("unchecked")
		List<LancamentoFinanceiroBean> list = c.list();
		s.close();

		return list;
	}

	public List<LancamentoFinanceiroBean> finalizados() {

		Session s = session();
		Criteria c = s.createCriteria(getBeanClass());
		c.add(Restrictions.eq("status", LancamentoFinanceiroStatus.REALIZADO));
		@SuppressWarnings("unchecked")
		List<LancamentoFinanceiroBean> list = c.list();
		s.close();

		return list;
	}
}