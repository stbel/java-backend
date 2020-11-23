package backend.core.estoque.producaoMateriaPrimaItem.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backend.core.estoque.producao.data.ProducaoBean;
import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "producaoMateriaPrimaItems")
public class ProducaoMateriaPrimaItemBean extends NamedBean {

	private ProdutoBean produto;

	private Integer quantidade;

	private ProducaoBean producao;

	@ManyToOne(fetch = FetchType.EAGER)
	public ProdutoBean getProduto() {

		return produto;
	}

	public void setProduto(ProdutoBean produto) {

		this.produto = produto;
	}

	public Integer getQuantidade() {

		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {

		this.quantidade = quantidade;
	}

	@ManyToOne
	public ProducaoBean getProducao() {
		return producao;
	}

	public void setProducao(ProducaoBean producao) {
		this.producao = producao;
	}

}