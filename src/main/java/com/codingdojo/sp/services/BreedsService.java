package com.codingdojo.sp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.sp.models.Breeds;
import com.codingdojo.sp.repository.BreedsRepository;

@Service
public class BreedsService {
    
	@Autowired
    private BreedsRepository breedRepository;
    public BreedsService(BreedsRepository breedRepository) {
		this.breedRepository = breedRepository;
    }
    
    public List<Breeds> getAllBreeds() {
		return (List<Breeds>) breedRepository.findAll();
		}

	public Breeds createBreed(Breeds b) {
		return breedRepository.save(b);
		}

	public Breeds findBrids(Integer id) {
		Optional<Breeds> optionalBreed = breedRepository.findById(id);
		if(optionalBreed.isPresent()) {
			return optionalBreed.get();
		} else {
			return null;
		}
	}
}
