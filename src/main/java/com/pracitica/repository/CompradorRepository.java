package com.pracitica.repository;

import com.pracitica.entity.CompradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompradorRepository extends JpaRepository<CompradorEntity, Long> {
    Optional<CompradorEntity> findByName(String name);
}
