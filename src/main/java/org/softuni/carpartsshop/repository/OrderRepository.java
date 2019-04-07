package org.softuni.carpartsshop.repository;

import org.softuni.carpartsshop.domain.entites.Order;
import org.softuni.carpartsshop.domain.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    List<Order> findAllOrdersByUser(User user);
}
