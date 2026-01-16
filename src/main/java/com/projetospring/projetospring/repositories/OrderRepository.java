package com.projetospring.projetospring.repositories;

import com.projetospring.projetospring.entities.Order;
import com.projetospring.projetospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
