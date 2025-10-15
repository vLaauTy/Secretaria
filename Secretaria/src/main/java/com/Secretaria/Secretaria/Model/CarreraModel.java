package com.Secretaria.Secretaria.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "carreras")

public class CarreraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String fechaAlta;

    @Column(nullable = false)
    private Integer cantidadMaterias;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column
    private String abreviatura;

    // Relación OneToMany con AlumnoModel
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.List<AlumnoModel> alumnos;

    // Relación OneToMany con MateriaModel
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private java.util.List<MateriaModel> materias;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public java.util.List<AlumnoModel> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(java.util.List<AlumnoModel> alumnos) {
        this.alumnos = alumnos;
    }

    public java.util.List<MateriaModel> getMaterias() {
        return materias;
    }

    public void setMaterias(java.util.List<MateriaModel> materias) {
        this.materias = materias;
    }
}
