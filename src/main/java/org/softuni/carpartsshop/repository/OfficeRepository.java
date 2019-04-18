package org.softuni.carpartsshop.repository;

import org.softuni.carpartsshop.domain.entites.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeRepository extends JpaRepository<Office,String> {
    
//    Optional<Office> findByName(String name);

    Optional<Office> findByAddress(String address);
}
