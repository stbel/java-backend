package backend.core.estoque.producaoFluxo.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import backend.core.estoque.producaoFase.data.ProducaoFaseBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "producaoFluxos")
public class ProducaoFluxoBean extends NamedBean {

	private List<ProducaoFaseBean> fases;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<ProducaoFaseBean> getFases() {
		return fases;
	}

	public void setFases(List<ProducaoFaseBean> fases) {
		this.fases = fases;
	}
}