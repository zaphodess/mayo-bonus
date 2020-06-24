package de.telekom.mayo.bonus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.telekom.mayo.bonus.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

}
