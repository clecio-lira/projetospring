package com.projetospring.projetospring.repositories;

import com.projetospring.projetospring.entities.OrderItem;
import com.projetospring.projetospring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
