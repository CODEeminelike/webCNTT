package appUtil;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBUtil {
	// An EntityManagerFactory object is declared.
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("eCommercePU");

	// Static method to return EntityManagerFactory object.
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
