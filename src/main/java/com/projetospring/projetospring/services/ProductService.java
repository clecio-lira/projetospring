package com.projetospring.projetospring.services;

import com.projetospring.projetospring.entities.Category;
import com.projetospring.projetospring.entities.Product;
import com.projetospring.projetospring.repositories.CategoryRepository;
import com.projetospring.projetospring.repositories.ProductRepository;
import com.projetospring.projetospring.services.exceptions.DatabaseException;
import com.projetospring.projetospring.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj) {
        try {
            Product entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product obj) {
        if (obj.getName() != null) {
            entity.setName(obj.getName());
        }
        if (obj.getDescription() != null) {
            entity.setDescription(obj.getDescription());
        }
        if (obj.getPrice() != null) {
            entity.setPrice(obj.getPrice());
        }
        if (obj.getImgUrl() != null) {
            entity.setImgUrl(obj.getImgUrl());
        }
    }
}













