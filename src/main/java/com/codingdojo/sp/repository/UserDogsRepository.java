package com.codingdojo.sp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.sp.models.UsersDogs;

@Repository
public interface UserDogsRepository extends CrudRepository<UsersDogs, Long> {
	@Query(value = "SELECT * FROM user_dogs ORDER BY id DESC;", nativeQuery = true)
	List<UsersDogs> findAll();
	 
	@Query(value = "SELECT * FROM user_dogs WHERE breed_id = ?1", nativeQuery = true)
	List<UsersDogs>findByBreedId(Long id);

	@Query(value = "SELECT * FROM user_dogs ORDER BY id DESC LIMIT 8", nativeQuery = true)
	List<UsersDogs>findLastadd();
	
	
}
