package com.Secretaria.Secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Secretaria.Secretaria.Model.ProfesorModel;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorModel, Long> {
    Optional<ProfesorModel> findByDni(String dni);
    void deleteByDni(String dni);
}
