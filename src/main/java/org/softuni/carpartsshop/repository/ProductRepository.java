package org.softuni.carpartsshop.repository;


import org.softuni.carpartsshop.domain.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
