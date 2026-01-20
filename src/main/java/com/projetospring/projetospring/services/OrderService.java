package com.projetospring.projetospring.services;

import com.projetospring.projetospring.entities.Order;
import com.projetospring.projetospring.entities.User;
import com.projetospring.projetospring.repositories.OrderRepository;
import com.projetospring.projetospring.repositories.UserRepository;
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
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order obj) {
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

    public Order update(Long id, Order obj) {
        try {
            Order entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Order entity, Order obj) {
        if (obj.getPayment() != null) {
            entity.setPayment(obj.getPayment());
        }
        if (obj.getOrderStatus() != null) {
            entity.setOrderStatus(obj.getOrderStatus());
        }
    }
}













