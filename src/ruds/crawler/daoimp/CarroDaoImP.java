package ruds.crawler.daoimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ruds.crawler.connect.ConnectionManager;
import ruds.crawler.dao.CarroDao;
import ruds.crawler.model.Carro;

public class CarroDaoImP implements CarroDao {

	EntityManager em = ConnectionManager.getEmf().createEntityManager();
	EntityTransaction transaction = em.getTransaction(); 
	
	@SuppressWarnings("unused")
	private boolean closeConnection = false;
	
	@Override
	public void save(Carro produto) {
		
	  try{
		   System.out.println(em.isOpen());
		  	transaction.begin();
			em.persist(produto);
			transaction.commit();
//			if(closeConnection)
//				em.close();
	  }
	  catch(Exception e){
		  e.printStackTrace();
		  e.getMessage();
		  e.getCause();
	  }
		

	}

	@Override
	public Carro findbyRegister(String register) {
		return em.find(Carro.class, register);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> listAll() {
		return em.createQuery("SELECT C FROM Carro C").getResultList();
	}

	public void setCloseConnection(boolean value) {
		this.closeConnection = value;
	}


}
