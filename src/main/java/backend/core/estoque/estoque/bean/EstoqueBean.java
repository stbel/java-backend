package backend.core.estoque.estoque.bean;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "estoques")
public class EstoqueBean extends Bean {

	private ProdutoBean produto;

	private Integer quantidade;

	@OneToOne
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
}