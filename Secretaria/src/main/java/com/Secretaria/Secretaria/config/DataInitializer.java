package com.Secretaria.Secretaria.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Secretaria.Secretaria.Model.AlumnoModel;
import com.Secretaria.Secretaria.Model.CarreraModel;
import com.Secretaria.Secretaria.Model.MateriaModel;
import com.Secretaria.Secretaria.Model.ProfesorModel;
import com.Secretaria.Secretaria.Model.UserModel;
import com.Secretaria.Secretaria.repository.AlumnoRepository;
import com.Secretaria.Secretaria.repository.CarreraRepository;
import com.Secretaria.Secretaria.repository.MateriaRepository;
import com.Secretaria.Secretaria.repository.ProfesorRepository;
import com.Secretaria.Secretaria.repository.UserRepository;

@Configuration
@Profile("h2")
public class DataInitializer {

    @Bean
    CommandLineRunner seedBasicData(
            CarreraRepository carreraRepo,
            ProfesorRepository profesorRepo,
            MateriaRepository materiaRepo,
            AlumnoRepository alumnoRepo,
            UserRepository userRepo) {
        return args -> {
            // Usuario admin/admin si no existe
            if (userRepo.findByUsername("admin").isEmpty()) {
                UserModel admin = new UserModel();
                admin.setUsername("admin");
                admin.setPassword("admin"); // PasswordEncoder actual compara texto plano
                admin.setRol("ADMIN");
                userRepo.save(admin);
            }

            // Carrera básica
            CarreraModel carrera;
            if (carreraRepo.count() == 0) {
                carrera = new CarreraModel();
                carrera.setNombre("Tecnicatura en Sistemas");
                carrera.setFechaAlta("2025-01-01");
                carrera.setCantidadMaterias(3);
                carrera.setCargaHoraria(1200);
                carrera.setAbreviatura("TSDS");
                carrera = carreraRepo.save(carrera);
            } else {
                carrera = carreraRepo.findAll().get(0);
            }

            // Profesor básico
            ProfesorModel profesor;
            if (profesorRepo.count() == 0) {
                profesor = new ProfesorModel();
                profesor.setNombre("Juan");
                profesor.setApellido("Pérez");
                profesor.setDni("20111222");
                profesor.setDomicilio("Av. Principal");
                profesor.setNro("1234");
                profesor.setPiso(null);
                profesor.setCodigoPostal("1700");
                profesor.setLocalidad("Morón");
                profesor.setPartida("ABC123");
                profesor.setTelefono("1122334455");
                profesor.setEmail("juan.perez@example.com");
                profesor.setFechaNacimiento("1980-05-10");
                profesor.setLugarNacimiento("Buenos Aires");
                profesor.setPais("Argentina");
                profesor.setFoja(1);
                profesor.setCertificadoAF(true);
                profesor.setSexo("Hombre");
                profesor = profesorRepo.save(profesor);
            } else {
                profesor = profesorRepo.findAll().get(0);
            }

            // Materia básica vinculada a carrera y profesor
            if (materiaRepo.count() == 0) {
                MateriaModel mat = new MateriaModel();
                mat.setNombre("Programación I");
                mat.setFechaAlta("2025-03-01");
                mat.setAnio("1°");
                mat.setCargaHoraria(128);
                mat.setHoraTotal("128hs-1");
                mat.setCarrera(carrera);
                mat.setProfesor(profesor);
                materiaRepo.save(mat);
            }

            // Alumno básico vinculado a carrera
            if (alumnoRepo.count() == 0) {
                AlumnoModel alu = new AlumnoModel();
                alu.setAno_lec(LocalDate.now().getYear());
                alu.setNroLeg(1);
                alu.setCarrera(carrera);
                alu.setDA_Ape("García");
                alu.setDA_Nom("María");
                alu.setDni("40123456");
                alumnoRepo.save(alu);
            }
        };
    }
}
