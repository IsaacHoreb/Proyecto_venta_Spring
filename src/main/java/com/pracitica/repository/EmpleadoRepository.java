package com.pracitica.repository;

import com.pracitica.entity.EmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadosEntity, Long> {
    Optional<EmpleadosEntity> findByName(String name);
}
