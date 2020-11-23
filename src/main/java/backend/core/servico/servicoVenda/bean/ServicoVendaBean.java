package backend.core.servico.servicoVenda.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import backend.core.cadastro.pessoa.data.PessoaBean;
import backend.core.frame.jpa.NamedBean;
import backend.core.servico.servico.bean.ServicoBean;

@Entity
@Table(name = "servicoVendas")
public class ServicoVendaBean extends NamedBean {
	
	private PessoaBean cliente;
	
	private ServicoBean servico;
	
	private List<PessoaBean> pessoas;
	
	@ManyToOne
	public PessoaBean getCliente() {
		return cliente;
	}

	public void setCliente(PessoaBean cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne
	public ServicoBean getServico() {
		return servico;
	}
	
	public void setServico(ServicoBean servico) {
		this.servico = servico;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<PessoaBean> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaBean> pessoas) {
		this.pessoas = pessoas;
	}
}