package com.codingdojo.sp.breed.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codingdojo.sp.models.UsersDogs;

@Repository
public interface DogBreedsRepository extends JpaRepository<UsersDogs, Long> {
	List<UsersDogs> findAll();

	@Query(value = "SELECT * FROM user_dogs WHERE breed_id = ?1", nativeQuery = true)
	List<UsersDogs>findById();
}
