package backend.core.cadastro.usuario.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.cadastro.pessoa.data.PessoaBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "usuarios")
public class UsuarioBean extends Bean {

	private String usuario;

	private String senha;

	private String sal;

	private PessoaBean pessoa;

	@Column(unique = true)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	@OneToOne
	public PessoaBean getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}

}