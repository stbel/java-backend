package backend.core.cadastro.fornecedor.data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.cadastro.pessoa.data.PessoaBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "fornecedores")
public class FornecedorBean extends NamedBean {

	private PessoaBean pessoa;

	@OneToOne
	public PessoaBean getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}

}
