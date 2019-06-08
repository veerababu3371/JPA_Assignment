package com.cg.jpastart.entities;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Book  storybook= new Book();
		storybook.setId(111);
		storybook.setTittle("stevjobs");
		storybook.setPrice(52000);

		Book  magicbook = new Book();
		magicbook.setId(112);
		magicbook.setTittle("magicshow");
		magicbook.setPrice(32000);

		Book  slidbook = new Book();
		slidbook.setId(2223);
		slidbook.setTittle("physics");
		slidbook.setPrice(82000);

		/*Book  stortbook1 = new Book();
		stortbook1.setId(4);
		stortbook1.setTittle("social");
		stortbook1.setPrice(6000);*/


		// now define first order and add few products in it
		Author firstAuthor = new Author();
		firstAuthor.setId(1206);
		firstAuthor.setName("uma");

		firstAuthor.addBook(slidbook);
		firstAuthor.addBook(magicbook);
		firstAuthor.addBook(storybook);

		// now define second order and add few products in it
		Author secondAuthor = new Author();
		secondAuthor.setId(1609);
		secondAuthor.setName("veeru");

		secondAuthor.addBook(slidbook);		
		secondAuthor.addBook(magicbook);
		secondAuthor.addBook(storybook);

		// save orders using entity manager

		em.persist(firstAuthor);
		em.persist(secondAuthor);
		
		System.out.println("Added Authors along with Author details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
		

	}

}
