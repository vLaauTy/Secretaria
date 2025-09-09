package com.Secretaria.Secretaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Secretaria.Secretaria.Model.AlumnoModel;
import com.Secretaria.Secretaria.repository.AlumnoRepository;

@Service
public class AlumnoService {
    private final AlumnoRepository repo;

    public AlumnoService(AlumnoRepository repo) {
        this.repo = repo;
    }

    public List<AlumnoModel> listarTodosLosAlumnos() {
        return repo.findAll();
    }

    public AlumnoModel save(AlumnoModel Alumno) {
        return repo.save(Alumno);
    }

    public Optional<AlumnoModel> findById(Long id) {
        return repo.findById(id);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public void guardarAlumno(AlumnoModel Alumno) {
        repo.save(Alumno);
    }
    
    @Transactional
    public boolean eliminarAlumnoPorDni(String dni) {
        Optional<AlumnoModel> Alumno = repo.findByDni(dni);
        if (Alumno.isPresent()) {
            repo.deleteByDni(dni);
            return true;
        }
        return false;
    }

}
