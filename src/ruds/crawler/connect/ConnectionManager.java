package ruds.crawler.connect;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {
	
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("default");

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public static void setEmf(EntityManagerFactory emf) {
		ConnectionManager.emf = emf;
	}

}
