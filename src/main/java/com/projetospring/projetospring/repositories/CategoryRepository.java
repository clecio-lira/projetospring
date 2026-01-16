package com.projetospring.projetospring.repositories;

import com.projetospring.projetospring.entities.Category;
import com.projetospring.projetospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
