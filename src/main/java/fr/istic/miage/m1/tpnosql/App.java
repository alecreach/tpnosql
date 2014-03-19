package fr.istic.miage.m1.tpnosql;

import java.net.UnknownHostException;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws UnknownHostException

	{

		Morphia morphia = new Morphia();

		Mongo mongo = new Mongo();

		morphia.map(Person.class).map(Address.class);

		Datastore ds = morphia.createDatastore(mongo, "my_database");

		
		// Déclarations 
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();

		p1.setName("Tintin");
		p2.setName("Haddock");
		p3.setName("Dupont");
		
		Article art1 = new Article();
		Article art2 = new Article();
		Article art3 = new Article();
		Article art4 = new Article();
		Article art5 = new Article();

		Address adr1 = new Address();
		Address adr2 = new Address();
		Address adr3 = new Address();
		Address adr4 = new Address();
		
		// Définitions des adresses
		
		adr1.setStreet("123 rue de la Gare");
		adr1.setCity("Nouille York");
		adr1.setPostCode("35000");
		adr1.setCountry("United States of Murrica");
		
		adr2.setStreet("12 rue de la Liberté");
		adr2.setCity("Turin");
		adr2.setPostCode("22492");
		adr2.setCountry("Italy");
		
		adr3.setStreet("25 boulevard des Alliés");
		adr3.setCity("Dusseldörf");
		adr3.setPostCode("15000");
		adr3.setCountry("Allemania");	
		
		adr4.setStreet("145 avenue Jacques Cousteau");
		adr4.setCity("Brest");
		adr4.setPostCode("29000");
		adr4.setCountry("Bretagne");
		
		// Définitions des articles
		
		art1.setName("Tondeuse à gazon");
		art1.setStars(4);
		art1.getPersonnes().add(p1);
		
		art2.setName("Artefact mystérieux");
		art2.setStars(5);
		art2.getPersonnes().add(p1);
		
		art3.setName("Pot de fleur");
		art3.setStars(1);
		art3.getPersonnes().add(p2);
		art3.getPersonnes().add(p1);
		
		art4.setName("Poële à frire");
		art4.setStars(6);
		art4.getPersonnes().add(p3);
		art4.getPersonnes().add(p2);
		art4.getPersonnes().add(p1);
		
		art5.setName("Panier à salade");
		art5.setStars(2);
		art5.getPersonnes().add(p3);
		
		// Liaisons Personnes/Adresses 
		
		p1.getAddress().add(adr1);		
		p2.getAddress().add(adr2);
		p2.getAddress().add(adr3);		
		p3.getAddress().add(adr4);
		
		// Save the POJO

		ds.save(art1);
		ds.save(art2);
		ds.save(art3);
		ds.save(art4);
		ds.save(art5);
		
		for (Article a : ds.find(Article.class)){
			System.out.println("Nom de l'article : "+a.getName());
			System.out.println("Note : "+a.getStars());
			List<Person> pers = a.getPersonnes();
			System.out.println(pers.size()+" acheteur(s) : ");
			for (Person p : pers){
				System.out.println("Nom : "+p.getName());
				List<Address> adr = p.getAddress();
				System.out.println("Adresse(s) : ");
				for(Address aa : adr){
					System.out.println(aa.getStreet()+" "+aa.getPostCode()+" "+aa.getCity()+" "+aa.getCountry());
				}
			}
			System.out.println("========================================================="+"\n");			
		}		
	}
}
