package fr.istic.miage.m1.tpnosql;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
public class Article {

	@Id ObjectId id;
	String name;
	int stars;
	
	List<Person> personnes = new ArrayList<Person>();
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public List<Person> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Person> personnes) {
		this.personnes = personnes;
	}
	
	
	
	
}
