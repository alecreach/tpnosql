package fr.istic.miage.m1.tpnosql;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
public class Article {

	@Id ObjectId id;
	String name;
	int stars;
	
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
	
	
	
}
