package com.msglearning.javabackend.repositories;

import com.msglearning.javabackend.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long > {
    List<Order> findAll();

    Optional<Order> findById(Long id);



}
