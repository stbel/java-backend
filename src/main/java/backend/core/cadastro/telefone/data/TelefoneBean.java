package backend.core.cadastro.telefone.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "telefones")
public class TelefoneBean extends Bean {

	private Integer codigoArea;

	private Integer numero;

	public Integer getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
