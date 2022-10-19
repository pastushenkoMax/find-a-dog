package com.codingdojo.sp.models;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="user_dogs")
public class UsersDogs {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Name is Required!")
    @Size(min = 3, max = 200, message="Name should be at least 3 character")
    private String dog_name;
    
	@NotNull(message="Description is Required!")
    @Size(min = 5, max = 1000, message="Description should be at least 5 character")
    private String dog_description;

	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="user_dogs_id")
    private Photo photo;

	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="breed_id")
    private Breeds breed;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDog_name() {
		return dog_name;
	}
	public void setDog_name(String dog_name) {
		this.dog_name = dog_name;
	}
	public String getDog_description() {
		return dog_description;
	}
	public void setDog_description(String dog_description) {
		this.dog_description = dog_description;
	}
	public Breeds getBreed() {
		return breed;
	}
	public void setBreed(Breeds breed) {
		this.breed = breed;
	}
	public UsersDogs() {}
	public UsersDogs(Long id, String dog_name, String dog_description, Breeds breed, User user, Photo photo) {
		this.id = id;
		this.dog_name = dog_name;
		this.dog_description = dog_description;
		this.breed = breed;
		this.user = user;
		this.photo = photo;
	}
	
}
