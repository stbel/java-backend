package backend.core.estoque.produto.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.estoque.embalagem.data.EmbalagemBean;
import backend.core.estoque.produtoVariacao.data.ProdutoVariacaoBean;
import backend.core.estoque.unidadeMedida.data.UnidadeMedidaBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "produtos")
public class ProdutoBean extends NamedBean {

	private String descricao;

	private List<ProdutoVariacaoBean> variacoes;

	private EmbalagemBean embalagem;

	private UnidadeMedidaBean unidadeMedida;

	private Integer quantidade;

	@OneToOne
	public EmbalagemBean getEmbalagem() {

		return embalagem;
	}

	public void setEmbalagem(EmbalagemBean embalagem) {

		this.embalagem = embalagem;
	}

	public String getDescricao() {

		return descricao;
	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	@ManyToOne
	public UnidadeMedidaBean getUnidadeMedida() {

		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedidaBean unidade) {

		this.unidadeMedida = unidade;
	}

	public Integer getQuantidade() {

		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {

		this.quantidade = quantidade;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<ProdutoVariacaoBean> getVariacoes() {

		return variacoes;
	}

	public void setVariacoes(List<ProdutoVariacaoBean> variacoes) {

		this.variacoes = variacoes;
	}

}
