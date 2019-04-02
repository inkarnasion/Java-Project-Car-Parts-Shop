package org.softuni.carpartsshop.repository;


import org.softuni.carpartsshop.domain.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
