package ruds.crawler.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ruds.crawler.connect.ConnectionManager;
import ruds.crawler.dao.ProdutoDao;
import ruds.crawler.model.Produto;


public class ProdutoDaoImP implements ProdutoDao{

	EntityManager em = ConnectionManager.getEmf().createEntityManager();
	EntityTransaction transaction = em.getTransaction(); 
	
	@Override
	public void save(Produto produto) {
		
	   try{	   
		transaction.begin();
		em.persist(produto);
		transaction.commit();
//		em.close();
	   }
	   catch(Exception e){
			  e.printStackTrace();
			  e.getMessage();
			  e.getCause();
		  }
	}
	
	
	@Override
	public void saveList(List<Produto> produtos) {
		
	   try{	   
		transaction.begin();
		for(int i=0;i<produtos.size();i++){
			em.persist(produtos.get(i));
		}
		transaction.commit();
		em.close();
	   }
	   catch(Exception e){
			  e.printStackTrace();
			  e.getMessage();
			  e.getCause();
		  }
	}
	

	@Override
	public Produto findbyCode(String code) {
		return em.find(Produto.class, code);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listAll() {
		return em.createQuery("SELECT P FROM Produto P").getResultList();
	}

}
