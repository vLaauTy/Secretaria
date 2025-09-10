package com.Secretaria.Secretaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Secretaria.Secretaria.Model.CarreraModel;
import com.Secretaria.Secretaria.repository.CarreraRepository;

@Service
public class CarreraService {
    private final CarreraRepository repo;

    public CarreraService(CarreraRepository repo) {
        this.repo = repo;
    }

    public List<CarreraModel> findAll() {
        return repo.findAll();
    }

    public CarreraModel save(CarreraModel carrera) {
        return repo.save(carrera);
    }

    public CarreraModel findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
