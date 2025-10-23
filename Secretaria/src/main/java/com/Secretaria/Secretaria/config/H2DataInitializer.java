package com.Secretaria.Secretaria.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Secretaria.Secretaria.Model.*;
import com.Secretaria.Secretaria.repository.*;

import java.time.LocalDate;

@Configuration
@Profile("h2")
public class H2DataInitializer {

    @Bean
    ApplicationRunner seedData(
            UserRepository userRepo,
            CarreraRepository carreraRepo,
            ProfesorRepository profesorRepo,
            MateriaRepository materiaRepo,
            AlumnoRepository alumnoRepo,
            UbicacionRepository ubicacionRepo) {
        return args -> {
            // Usuario admin/admin
            if (userRepo.findByUsername("admin").isEmpty()) {
                UserModel admin = new UserModel();
                admin.setUsername("admin");
                admin.setPassword("admin"); // PasswordEncoder actual compara plano
                admin.setRol("ADMIN");
                admin.setIntentosFallidos(0);
                admin.setBloqueado(false);
                userRepo.save(admin);
            }

            // Carrera base
            CarreraModel carrera;
            if (carreraRepo.count() == 0) {
                carrera = new CarreraModel();
                carrera.setNombre("Tecnicatura en Sistemas");
                carrera.setFechaAlta("2025-01-01");
                carrera.setCantidadMaterias(10);
                carrera.setCargaHoraria(1200);
                carrera.setAbreviatura("TSDS");
                carrera = carreraRepo.save(carrera);
            } else {
                carrera = carreraRepo.findAll().get(0);
            }

            // Profesor base (campos obligatorios)
            ProfesorModel profesor;
            if (profesorRepo.count() == 0) {
                profesor = new ProfesorModel();
                profesor.setNombre("Carlos");
                profesor.setApellido("García");
                profesor.setDni("20123456");
                profesor.setDomicilio("Av. Siempre Viva");
                profesor.setNro("742");
                profesor.setPiso("1");
                profesor.setCodigoPostal("1000");
                profesor.setLocalidad("CABA");
                profesor.setPartida("Partida-001");
                profesor.setTelefono("1144444444");
                profesor.setEmail("carlos.garcia@example.com");
                profesor.setFechaNacimiento("1985-05-20");
                profesor.setLugarNacimiento("Buenos Aires");
                profesor.setPais("Argentina");
                profesor.setFoja(1);
                profesor.setCertificadoAF(true);
                profesor.setSexo("Hombre");
                profesor = profesorRepo.save(profesor);
            } else {
                profesor = profesorRepo.findAll().get(0);
            }

            // Materia base
            if (materiaRepo.count() == 0) {
                MateriaModel materia = new MateriaModel();
                materia.setNombre("Programación I");
                materia.setFechaAlta("2025-03-01");
                materia.setAnio("1°");
                materia.setCargaHoraria(256);
                materia.setHoraTotal("256");
                materia.setCarrera(carrera);
                materia.setProfesor(profesor);
                materiaRepo.save(materia);
            }

            // Alumno base
            if (alumnoRepo.count() == 0) {
                AlumnoModel alumno = new AlumnoModel();
                alumno.setAno_lec(2025);
                alumno.setNroLeg(1);
                alumno.setCarrera(carrera);
                alumno.setAñoCarrera("1°");
                alumno.setDA_Ape("Pérez");
                alumno.setDA_Nom("Juan");
                alumno.setDA_Sex("Masculino");
                alumno.setDA_FeNa(LocalDate.of(2005, 1, 1));
                alumno.setDA_PaisNa("Argentina");
                alumno.setDni("12345678");
                alumnoRepo.save(alumno);
            }

            // Ubicación base
            if (ubicacionRepo.count() == 0) {
                Ubicacion u = new Ubicacion();
                u.setTitulo("Biblioteca - Tomo I");
                u.setDireccion("Estantería A, Fila 1, Sector Principal");
                ubicacionRepo.save(u);
            }
        };
    }
}
