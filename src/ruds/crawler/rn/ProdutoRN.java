package ruds.crawler.rn;

import java.util.List;

import ruds.crawler.dao.ProdutoDao;
import ruds.crawler.daoimp.ProdutoDaoImP;
import ruds.crawler.model.Produto;


public class ProdutoRN {
	
	private ProdutoDao dao = new ProdutoDaoImP();
	
	public List<Produto> todosProdutos(){	
		return this.dao.listAll();
	}
	
	public void salvaProduto(Produto produto){
		this.dao.save(produto);
	}
	
	public void salvaProdutos(List<Produto> produtos){
		
		System.out.println("Tamanho lista de Produtos: " + produtos.size());
			this.dao.saveList(produtos);
	}
	
	public Produto buscaPorCodigo(String codigo){
		return this.dao.findbyCode(codigo);
	}

}
