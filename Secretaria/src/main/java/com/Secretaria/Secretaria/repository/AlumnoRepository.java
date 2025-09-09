package com.Secretaria.Secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Secretaria.Secretaria.Model.AlumnoModel;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<AlumnoModel, Long> {
    Optional<AlumnoModel> findByDni(String dni);
    void deleteByDni(String dni);
}
