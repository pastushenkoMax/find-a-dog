package com.codingdojo.sp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.sp.models.Photo;
import com.codingdojo.sp.qphoto.repository.QPhotoRepository;

@Service
public class qPhotoService {
	

	@Autowired QPhotoRepository qPhotoRepository;
	public qPhotoService(QPhotoRepository qPhotoRepository) {
		this.qPhotoRepository = qPhotoRepository;
	}

	public List<Photo> listAll(Long id) {
        if (id != null) {
            return qPhotoRepository.findByID(id);
        }
        return qPhotoRepository.findAll();
    }
	
	public void deletePic(Long id) {
		qPhotoRepository.deletByID(id);
	}
}
