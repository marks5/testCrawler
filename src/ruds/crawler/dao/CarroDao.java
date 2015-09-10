package ruds.crawler.dao;

import java.util.List;

import ruds.crawler.model.Carro;

public interface CarroDao {
	
	boolean closeConnection = false;
	
	public void save(Carro carro);
	
	public Carro findbyRegister(String register);
	
	public List<Carro> listAll(); 
	
	public void setCloseConnection(boolean value);

}
