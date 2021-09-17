package com.fgh.examen_backend.repositories;

import com.fgh.examen_backend.models.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
    SupplierModel findBySupplierName(String name);
}