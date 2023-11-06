package com.pracitica.repository;

import com.pracitica.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
    Optional<CarroEntity> findByMarca(String marca);
}
