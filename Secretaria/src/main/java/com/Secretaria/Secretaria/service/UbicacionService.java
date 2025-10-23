package com.Secretaria.Secretaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Secretaria.Secretaria.Model.Ubicacion;
import com.Secretaria.Secretaria.repository.UbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Ubicacion guardarUbicacion(String titulo, String direccion) {
        Ubicacion u = new Ubicacion();
        u.setTitulo(titulo);
        u.setDireccion(direccion);
        return ubicacionRepository.save(u);
    }

    public List<Ubicacion> listarUbicaciones() {
        return ubicacionRepository.findAll();
    }

    public void eliminarUbicacion(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
