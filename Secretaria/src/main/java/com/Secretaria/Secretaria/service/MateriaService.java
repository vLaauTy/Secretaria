package com.Secretaria.Secretaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Secretaria.Secretaria.Model.MateriaModel;
import com.Secretaria.Secretaria.repository.MateriaRepository;

@Service
public class MateriaService {
    private final MateriaRepository repo;

    public MateriaService(MateriaRepository repo) {
        this.repo = repo;
    }

    public List<MateriaModel> findAll() {
        return repo.findAll();
    }

    public MateriaModel save(MateriaModel materia) {
        return repo.save(materia);
    }

    public MateriaModel findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
