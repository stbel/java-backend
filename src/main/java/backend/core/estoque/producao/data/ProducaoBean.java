package backend.core.estoque.producao.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import backend.core.estoque.producaoFluxo.data.ProducaoFluxoBean;
import backend.core.estoque.producaoMateriaPrimaItem.data.ProducaoMateriaPrimaItemBean;
import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "producaos")
public class ProducaoBean extends NamedBean {

	private ProdutoBean produto;

	private ProducaoFluxoBean fluxo;

	private List<ProducaoMateriaPrimaItemBean> materiasPrimas;

	@OneToOne
	public ProdutoBean getProduto() {
		return produto;
	}

	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}

	@OneToOne
	public ProducaoFluxoBean getFluxo() {
		return fluxo;
	}

	public void setFluxo(ProducaoFluxoBean fluxo) {
		this.fluxo = fluxo;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	public List<ProducaoMateriaPrimaItemBean> getMateriasPrimas() {
		return materiasPrimas;
	}

	public void setMateriasPrimas(List<ProducaoMateriaPrimaItemBean> materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}

}