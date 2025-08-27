package com.Secretaria.Secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Secretaria.Secretaria.Model.MateriaModel;

@Repository
public interface MateriaRepository extends JpaRepository<MateriaModel, Long> {

}
