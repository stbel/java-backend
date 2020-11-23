package backend.core.estoque.produtoVariacao.data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backend.core.estoque.produtoVariacaoTipo.data.ProdutoVariacaoTipoBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "produto_variacoes")
public class ProdutoVariacaoBean extends NamedBean {

	private ProdutoVariacaoTipoBean tipo;

	@ManyToOne
	public ProdutoVariacaoTipoBean getTipo() {

		return tipo;
	}

	public void setTipo(ProdutoVariacaoTipoBean tipo) {

		this.tipo = tipo;
	}
}
