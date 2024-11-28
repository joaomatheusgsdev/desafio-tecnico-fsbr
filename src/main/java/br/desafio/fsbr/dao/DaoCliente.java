package br.desafio.fsbr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.desafio.fsbr.entidades.Cliente;
import br.desafio.fsbr.util.JPAUtil;

public class DaoCliente<E> {
	
	
	public void salvar(Cliente cliente) {
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.persist(cliente);
		
		entityTransaction.commit();
		
		entityManager.close();
		
	}
	
	
	public Cliente merge(Cliente cliente) {
				
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.merge(cliente);
		
		entityTransaction.commit();
		
		entityManager.close();
		
		return cliente;
		
	}
	
	
	public void deletePorID(Long id) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
				
		entityManager.createQuery("DELETE FROM Cliente where id = "+id).executeUpdate();
				
		entityTransaction.commit();
		
		entityManager.close();
			
	}
	
	
	public List<Cliente> listarClientes() {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		Query q = entityManager.createQuery("SELECT c FROM Cliente c");
		
		List<Cliente> clientes = q.getResultList();
				
		entityTransaction.commit();
		
		entityManager.close();
		
		System.out.println(clientes.toString());
		
		
		return clientes;
			
	}
	
	


}
