package com.codingdojo.sp.qphoto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codingdojo.sp.models.Photo;

@Repository
public interface QPhotoRepository extends JpaRepository<Photo, Long> {

	@Query(value = "SELECT * FROM photos WHERE user_dogs_id = ?1", nativeQuery = true)
	List<Photo> findByID(Long photo);
	
	@Query(value = "SET FOREIGN_KEY_CHECKS = 0;", nativeQuery = true)
	List<Photo> deletByID(Long photo);
	
}