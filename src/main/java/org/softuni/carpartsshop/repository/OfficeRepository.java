package org.softuni.carpartsshop.repository;

import org.softuni.carpartsshop.domain.entites.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office,String> {
    
//    Optional<Office> findByName(String name);
@Query("select o from Office o where o.address=:address")
    Optional<Office> findByAddress(String address);
}
