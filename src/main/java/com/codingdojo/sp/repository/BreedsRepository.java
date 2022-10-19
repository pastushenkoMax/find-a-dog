package com.codingdojo.sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.sp.models.Breeds;

@Repository
public interface BreedsRepository extends CrudRepository<Breeds, Integer> {
	 List<Breeds> findAll();
}
