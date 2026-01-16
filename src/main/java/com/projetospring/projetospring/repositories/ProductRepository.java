package com.projetospring.projetospring.repositories;

import com.projetospring.projetospring.entities.Category;
import com.projetospring.projetospring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
