package com.codingdojo.sp.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.sp.models.Photo;
import com.codingdojo.sp.models.UsersDogs;
import com.codingdojo.sp.repository.UserDogsRepository;

@Service
public class UserDogsService {
    
	@Autowired
    private UserDogsRepository uDogsRepository;
    public  UserDogsService(UserDogsRepository uDogsRepository) {
		this.uDogsRepository = uDogsRepository;
    }
    
    public UsersDogs createNewDog(@Valid UsersDogs uDog, Photo photo, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    		}else {
    			uDog.setPhoto(photo);
    			return uDogsRepository.save(uDog);
    		}
		}
	public List<UsersDogs> findAll() {
		return uDogsRepository.findAll();
	}
	public void saveImg(MultipartFile imgFile) throws IOException {
    	String folder = "/photo_from_find_a_dog/";
    	byte[] bytes = imgFile.getBytes();
    	Path path = Paths.get(folder + imgFile.getOriginalFilename());
    	Files.write(path, bytes);
    	
    	
    }

	public UsersDogs findDogByID(Long id) {
		Optional<UsersDogs> dog = uDogsRepository.findById(id);
	    	if(dog.isPresent()) {
	    		return dog.get();
	    		} else {
	    			return null;
	    			}
	    	
	}

	public List<UsersDogs> findDogsByBreedID(Long id) {
		return uDogsRepository.findByBreedId(id);
		
	}

	public List<UsersDogs> findLastDogs() {
			return uDogsRepository.findLastadd();
			
		}

	public UsersDogs updateDog(@Valid UsersDogs d, Photo photo, BindingResult result) {
		if(result.hasErrors()) {
    		return null;
    		}else {
    			d.setPhoto(photo);
    			return uDogsRepository.save(d);
    		}
		}

	public void deleteDog(Long id) {
		uDogsRepository.deleteById(id);
	}
}
