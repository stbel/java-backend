package backend.core.estoque.pedidoItem.data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backend.core.estoque.pedido.data.PedidoBean;
import backend.core.estoque.produto.data.ProdutoBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "pedido_itens")
public class PedidoItemBean extends Bean {

	private ProdutoBean produto;

	private Integer quantidade;

	private BigDecimal precoUnidade;
	
	private Integer descontoNegocial;

	private PedidoBean pedido;

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

	public BigDecimal getPrecoUnidade() {

		return precoUnidade;
	}

	public void setPrecoUnidade(BigDecimal precoUnidade) {

		this.precoUnidade = precoUnidade;
	}

	@ManyToOne
	public PedidoBean getPedido() {

		return pedido;
	}

	public void setPedido(PedidoBean pedido) {

		this.pedido = pedido;
	}

	public Integer getDescontoNegocial() {
		return descontoNegocial;
	}

	public void setDescontoNegocial(Integer descontoNegocial) {
		this.descontoNegocial = descontoNegocial;
	}
}