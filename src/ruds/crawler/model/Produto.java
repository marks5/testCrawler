package ruds.crawler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 8717397290824399552L;
	
	@Id	
	@Column(name="ID_PRODUTO")
	private String codigoProduto;
	
	@Column
	private String descricaoProduto;
	
	@Column
	private String detalhesProduto;
	
	@Column(length=1500)
	private String outrosCodigoProduto;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Carro> listaCarros = new ArrayList<>();
	
	public Produto(){
		
	}
	
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getDetalhesProduto() {
		return detalhesProduto;
	}
	public void setDetalhesProduto(String detalhesProduto) {
		this.detalhesProduto = detalhesProduto;
	}
	public String getOutrosCodigoProduto() {
		return outrosCodigoProduto;
	}
	public void setOutrosCodigoProduto(String outrosCodigoProduto) {
		this.outrosCodigoProduto = outrosCodigoProduto;
	}
	public List<Carro> getListaCarros() {
		return listaCarros;
	}
	public void setListaCarros(List<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoProduto == null) ? 0 : codigoProduto.hashCode());
		result = prime
				* result
				+ ((descricaoProduto == null) ? 0 : descricaoProduto.hashCode());
		result = prime * result
				+ ((detalhesProduto == null) ? 0 : detalhesProduto.hashCode());
		result = prime
				* result
				+ ((outrosCodigoProduto == null) ? 0 : outrosCodigoProduto
						.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigoProduto == null) {
			if (other.codigoProduto != null)
				return false;
		} else if (!codigoProduto.equals(other.codigoProduto))
			return false;
		if (descricaoProduto == null) {
			if (other.descricaoProduto != null)
				return false;
		} else if (!descricaoProduto.equals(other.descricaoProduto))
			return false;
		if (detalhesProduto == null) {
			if (other.detalhesProduto != null)
				return false;
		} else if (!detalhesProduto.equals(other.detalhesProduto))
			return false;
		if (outrosCodigoProduto == null) {
			if (other.outrosCodigoProduto != null)
				return false;
		} else if (!outrosCodigoProduto.equals(other.outrosCodigoProduto))
			return false;
		return true;
	}

}
