package com.codingdojo.sp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_of_dogs")
public class Breeds {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String breed;
    @OneToMany(mappedBy="breed", fetch = FetchType.LAZY)
    private List<UsersDogs> userDogs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBreed() {
		return breed;
	}

	public List<UsersDogs> getUserDogs() {
		return userDogs;
	}

	public void setUserDogs(List<UsersDogs> userDogs) {
		this.userDogs = userDogs;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public Breeds() {}
	public Breeds(int id, String breed, List<UsersDogs> userDogs) {
		this.id = id;
		this.breed = breed;
		this.userDogs = userDogs;
	}
	
}
