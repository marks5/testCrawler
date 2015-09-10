package ruds.crawler.rn;

import java.util.List;
import ruds.crawler.dao.CarroDao;
import ruds.crawler.daoimp.CarroDaoImP;
import ruds.crawler.model.Carro;

public class CarroRN {

	private CarroDao dao = new CarroDaoImP();
	
	public List<Carro> todosCarros(){	
		return this.dao.listAll();
	}
	
	public void salvaCarros(List<Carro> carros){
		
		for(int i=0;i<carros.size();i++)
		{
			this.dao.save(carros.get(i));
			if(i==carros.size()-1)
				dao.setCloseConnection(true);
		}
		
	}
	
	public Carro buscaPorRegistro(String registro){
		return this.dao.findbyRegister(registro);
	}
	
}
