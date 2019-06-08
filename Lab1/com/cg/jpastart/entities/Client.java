package com.cg.jpastart.entities;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Greet greet = new Greet();
		greet.setMessage("Welcome to JPA!");
		
		em.persist(greet);
		
		System.out.println("Added greeting to database.");

		transaction.commit();
		em.close();
		factory.close();
	}


}
