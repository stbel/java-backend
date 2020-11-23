package backend.core.estoque.unidadeMedida.data;

import javax.persistence.Entity;
import javax.persistence.Table;

import backend.core.frame.jpa.NamedBean;

@Entity
@Table(name = "unidades_medida")
public class UnidadeMedidaBean extends NamedBean {

	private String abreviacao;

	public String getAbreviacao() {

		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {

		this.abreviacao = abreviacao;
	}
}
