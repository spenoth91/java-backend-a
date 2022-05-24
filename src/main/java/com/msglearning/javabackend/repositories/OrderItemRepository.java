package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long > {
    List<OrderItem> findAll();

    Optional<OrderItem> findById(Long id);

}
