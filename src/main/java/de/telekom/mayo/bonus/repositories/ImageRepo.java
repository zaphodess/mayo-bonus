package de.telekom.mayo.bonus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.telekom.mayo.bonus.entities.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

	Optional<Image> findByReferenceId(Long referenceId);
	
	


}
