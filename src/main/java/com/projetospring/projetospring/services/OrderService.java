package com.projetospring.projetospring.services;

import com.projetospring.projetospring.entities.Order;
import com.projetospring.projetospring.entities.User;
import com.projetospring.projetospring.repositories.OrderRepository;
import com.projetospring.projetospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }
}













