package de.telekom.mayo.bonus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.mayo.bonus.entities.Image;
import de.telekom.mayo.bonus.repositories.ImageRepo;


@RestController
@RequestMapping("/api/v1/images")
public class ImageRestController {
	
	@Autowired
	private ImageRepo imageRepo;
	
	@GetMapping
	public List<Image> findAllImages (){
		return imageRepo.findAll();	
	}
	
	@GetMapping ("/{id}")
	public Image findImageById (@PathVariable Long id){
		return this.imageRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
//	@GetMapping ("/{referenceId}")
//	public ResponseEntity<byte[]> findByReferenceId(@PathVariable Long referenceId) {
//		Optional<Image> bild = imageRepo.findByReferenceId(referenceId);
//		if (bild.isPresent()) {
//			MultiValueMap<String, String> headers = new HttpHeaders();
//			headers.set(HttpHeaders.CONTENT_TYPE, bild.get().getImageFormat());
//			return ResponseEntity
//					.status(HttpStatus.OK)
//					.contentType(MediaType.IMAGE_PNG)
//					.header(HttpHeaders.CONTENT_TYPE (bild.get().getImageFormat());
//	
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	}
	
	@GetMapping("byReferenceId/{referenceId}")
	public ResponseEntity<byte[]> findByReferenceId(@PathVariable ("referenceId") Long referenceId) {
		
		Optional<Image> image = imageRepo.findByReferenceId(referenceId);
	
		if (image.isPresent()) {
			HttpHeaders headers = new HttpHeaders ();
			headers.set(HttpHeaders.CONTENT_TYPE, image.get().getImageFormat());
			return new ResponseEntity<>(image.get().getContent(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

}}
