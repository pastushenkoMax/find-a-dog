package com.codingdojo.sp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.sp.models.Photo;
@Repository
public interface PhotoRepositorry extends CrudRepository<Photo, Long>{

}
