package backend.core.estoque.producaoExecucao.data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backend.core.estoque.producao.data.ProducaoBean;
import backend.core.estoque.producaoFase.data.ProducaoFaseBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "producaoExecucaos")
public class ProducaoExecucaoBean extends Bean {
	
	private ProducaoBean producao;
	
	private ProducaoFaseBean faseAtual;

	@OneToOne
	public ProducaoBean getProducao() {
		return producao;
	}

	public void setProducao(ProducaoBean producao) {
		this.producao = producao;
	}
	
	@OneToOne
	public ProducaoFaseBean getFaseAtual() {
		return faseAtual;
	}

	public void setFaseAtual(ProducaoFaseBean faseAtual) {
		this.faseAtual = faseAtual;
	}
}