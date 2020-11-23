package backend.core.cadastro.redeSocialPerfil.data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.cadastro.pessoa.data.PessoaBean;
import backend.core.cadastro.redeSocial.data.RedeSocialBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "redes_sociais_perfis")
public class RedeSocialPerfilBean extends Bean {

	private RedeSocialBean redeSocial;

	private PessoaBean pessoa;

	private String perfil;

	@ManyToOne
	public RedeSocialBean getRedeSocial() {

		return redeSocial;
	}

	public void setRedeSocial(RedeSocialBean redeSocial) {

		this.redeSocial = redeSocial;
	}

	@OneToOne
	public PessoaBean getPessoa() {

		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {

		this.pessoa = pessoa;
	}

	public String getPerfil() {

		return perfil;
	}

	public void setPerfil(String perfil) {

		this.perfil = perfil;
	}
}