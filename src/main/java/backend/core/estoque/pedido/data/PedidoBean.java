package backend.core.estoque.pedido.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import backend.core.cadastro.pessoa.data.PessoaBean;
import backend.core.estoque.pedidoItem.data.PedidoItemBean;
import backend.core.financeiro.pagamento.data.PagamentoBean;
import backend.core.frame.jpa.Bean;

@Entity
@Table(name = "pedidos")
public class PedidoBean extends Bean {

	private PessoaBean pessoa;

	private LocalDate data;

	private PagamentoBean pagamento;

	private PedidoTipo tipo;

	private PedidoStatus status;

	private List<PedidoItemBean> itens = new ArrayList<PedidoItemBean>();

	@ManyToOne(fetch = FetchType.EAGER)
	public PessoaBean getPessoa() {

		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {

		this.pessoa = pessoa;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public PagamentoBean getPagamento() {

		return pagamento;
	}

	public void setPagamento(PagamentoBean pagamento) {

		this.pagamento = pagamento;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pedido")
	@Fetch(FetchMode.SUBSELECT)
	public List<PedidoItemBean> getItens() {

		return itens;
	}

	public void setItens(List<PedidoItemBean> itens) {

		this.itens = itens;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public PedidoTipo getTipo() {

		return tipo;
	}

	public void setTipo(PedidoTipo tipo) {

		this.tipo = tipo;
	}

	@Enumerated(EnumType.STRING)
	public PedidoStatus getStatus() {

		return status;
	}

	public void setStatus(PedidoStatus status) {

		this.status = status;
	}

	public LocalDate getData() {

		return data;
	}

	public void setData(LocalDate data) {

		this.data = data;
	}

}