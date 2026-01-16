package com.projetospring.projetospring.services;

import com.projetospring.projetospring.entities.Category;
import com.projetospring.projetospring.entities.User;
import com.projetospring.projetospring.repositories.CategoryRepository;
import com.projetospring.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}













