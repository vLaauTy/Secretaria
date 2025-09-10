package com.Secretaria.Secretaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Secretaria.Secretaria.Model.CarreraModel;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraModel, Long> {

}