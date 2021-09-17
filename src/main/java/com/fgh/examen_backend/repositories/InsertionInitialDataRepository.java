package com.fgh.examen_backend.repositories;


import com.fgh.examen_backend.models.InsertionInitialData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertionInitialDataRepository extends JpaRepository<InsertionInitialData, Long> {
}
