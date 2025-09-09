package com.Secretaria.Secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Secretaria.Secretaria.Model.ProfesorModel;
import com.Secretaria.Secretaria.repository.ProfesorRepository;

@Service
public class ProfesorService {
    private final ProfesorRepository repo;

    public ProfesorService(ProfesorRepository repo) {
        this.repo = repo;
    }

    public List<ProfesorModel> listarTodosLosProfesores() {
        return repo.findAll();
    }

    public ProfesorModel save(ProfesorModel profesor) {
        return repo.save(profesor);
    }

    public Optional<ProfesorModel> findById(Long id) {
        return repo.findById(id);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public void guardarProfesor(ProfesorModel profesor) {
        repo.save(profesor);
    }

    @Transactional
    public boolean eliminarProfesorPorDni(String dni) {
        Optional<ProfesorModel> profesor = repo.findByDni(dni);
        if (profesor.isPresent()) {
            repo.deleteByDni(dni);
            return true;
        }
        return false;
    }

    public Optional<ProfesorModel> findByDni(String dni) {
        return repo.findByDni(dni);
    }

}
