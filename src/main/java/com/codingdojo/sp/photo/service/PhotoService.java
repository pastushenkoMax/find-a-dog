package com.codingdojo.sp.photo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.sp.models.Photo;
import com.codingdojo.sp.repository.PhotoRepositorry;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepositorry pRepositorry;
	public PhotoService(PhotoRepositorry pRepositorry) {
			this.pRepositorry = pRepositorry;
	    }
	public void save(Photo photo) {
		pRepositorry.save(photo);
	}
	
	public void saveImg(MultipartFile imgFile, Photo photo) throws IOException {
    	Path curentPath = Paths.get(".");
    	Path absolutePaths = curentPath.toAbsolutePath();
    	photo.setPath(absolutePaths + "/src/main/resources/static/photos/");
    	byte[] bytes = imgFile.getBytes();
    	Path path = Paths.get(photo.getPath() + imgFile.getOriginalFilename());
    	Files.write(path, bytes);
    	
    	
    }
}
