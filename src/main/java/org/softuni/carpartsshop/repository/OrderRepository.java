package org.softuni.carpartsshop.repository;

import java.util.List;

import org.softuni.carpartsshop.domain.entites.Order;
import org.softuni.carpartsshop.domain.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	List<Order> findAllOrdersByCustomer(User customer);
}
