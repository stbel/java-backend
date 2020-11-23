package backend.core.cadastro.endereco.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "enderecos")
public class EnderecoBean extends Bean {

	private String rua;

	private String numero;

	private String complemento;

	private String cep;

	public String getRua() {

		return rua;
	}

	public void setRua(String rua) {

		this.rua = rua;
	}

	public String getNumero() {

		return numero;
	}

	public void setNumero(String numero) {

		this.numero = numero;
	}

	public String getComplemento() {

		return complemento;
	}

	public void setComplemento(String complemento) {

		this.complemento = complemento;

	}

	public String getCep() {

		return cep;
	}

	public void setCep(String cep) {

		this.cep = cep;
	}

}