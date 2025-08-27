package com.Secretaria.Secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Secretaria.Secretaria.Model.ProfesorModel;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorModel, Long> {

}
