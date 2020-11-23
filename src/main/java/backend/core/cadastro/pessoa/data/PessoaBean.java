package backend.core.cadastro.pessoa.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import backend.core.cadastro.email.data.EmailBean;
import backend.core.cadastro.endereco.data.EnderecoBean;
import backend.core.cadastro.redeSocialPerfil.data.RedeSocialPerfilBean;
import backend.core.cadastro.telefone.data.TelefoneBean;
import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "pessoas")
public class PessoaBean extends NamedBean {

	private List<EnderecoBean> enderecos = new ArrayList<>();

	private List<EmailBean> emails = new ArrayList<>();

	private List<TelefoneBean> telefones = new ArrayList<>();

	private List<RedeSocialPerfilBean> redeSocialPerfis = new ArrayList<>();

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<EnderecoBean> getEnderecos() {

		if (enderecos == null) {
			enderecos = new ArrayList<>();
		}
		return enderecos;
	}

	public void setEnderecos(List<EnderecoBean> enderecos) {

		this.enderecos = enderecos;
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<EmailBean> getEmails() {

		return emails;
	}

	public void setEmails(List<EmailBean> emails) {

		this.emails = emails;
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<TelefoneBean> getTelefones() {

		return telefones;
	}

	public void setTelefones(List<TelefoneBean> telefones) {

		this.telefones = telefones;
	}

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<RedeSocialPerfilBean> getRedeSocialPerfis() {

		return redeSocialPerfis;
	}

	public void setRedeSocialPerfis(List<RedeSocialPerfilBean> redeSocialPerfis) {

		this.redeSocialPerfis = redeSocialPerfis;
	}

}
