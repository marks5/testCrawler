package ruds.crawler.dao;

import java.util.List;

import ruds.crawler.model.Produto;


public interface ProdutoDao {
	
	public void save(Produto produto);
	
	public void saveList(List<Produto> produto);
	
	public Produto findbyCode(String code);
	
	public List<Produto> listAll(); 

}
