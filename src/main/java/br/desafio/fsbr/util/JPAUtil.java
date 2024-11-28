package br.desafio.fsbr.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.desafio.fsbr.entidades.Cliente;

public class JPAUtil {
	
	private static EntityManagerFactory factory = null;
	
	static {
		if(factory == null) {
			factory = Persistence
			.createEntityManagerFactory("desafiotecnicofsbr");

		}
	}
	
	
	public static EntityManager getEntityManager() {
		
		return factory.createEntityManager();
	}
	
	
	
	public static Object getPrimaryKey(Cliente c) {
		
		return factory.getPersistenceUnitUtil().getIdentifier(c);
	}
	
	}


