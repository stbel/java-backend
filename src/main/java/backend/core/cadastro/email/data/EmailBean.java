package backend.core.cadastro.email.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "emails")
public class EmailBean extends Bean {

	private String endereco;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
