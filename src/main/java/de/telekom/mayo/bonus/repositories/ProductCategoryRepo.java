package de.telekom.mayo.bonus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.telekom.mayo.bonus.entities.ProductCategory;


@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long> {

}
