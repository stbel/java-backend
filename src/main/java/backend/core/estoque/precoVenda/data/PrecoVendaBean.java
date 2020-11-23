package backend.core.estoque.precoVenda.data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "precos_venda")
public class PrecoVendaBean extends Bean {

	private ProdutoBean produto;

	private BigDecimal valorBase;

	@OneToOne
	public ProdutoBean getProduto() {

		return produto;
	}

	public void setProduto(ProdutoBean produto) {

		this.produto = produto;
	}

	public BigDecimal getValorBase() {

		return valorBase;
	}

	public void setValorBase(BigDecimal valorBase) {

		this.valorBase = valorBase;
	}
}