package com.Secretaria.Secretaria.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "profesores")
public class ProfesorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String domicilio;

    @Column
    private String nro;

    @Column
    private String piso;

    @Column(nullable = false)
    private String CodigoPostal;

    @Column(nullable = false)
    private String localidad;

    @Column(nullable = false)
    private String partida;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String fechaNacimiento;

    @Column(nullable = false)
    private String lugarNacimiento;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private Integer foja;

    @Column(nullable = false)
    private Boolean certificadoAF;

    @Column(nullable = false)
    private String sexo;

    // Campo calculado - no se persiste en la base de datos
    @Transient
    private Integer edad;

        // Relación OneToMany con MateriaModel
        @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private java.util.List<MateriaModel> materias;

    // Getters y Setters
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getFoja() {
        return foja;
    }

    public void setFoja(Integer foja) {
        this.foja = foja;
    }

    public Boolean getCertificadoAF() {
        return certificadoAF;
    }

    public void setCertificadoAF(Boolean certificadoAF) {
        this.certificadoAF = certificadoAF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            try {
                LocalDate fechaNac = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate ahora = LocalDate.now();
                return Period.between(fechaNac, ahora).getYears();
            } catch (Exception e) {
                return null; // Si hay error en el formato de fecha
            }
        }
        return null;
    }

        public java.util.List<MateriaModel> getMaterias() {
            return materias;
        }

        public void setMaterias(java.util.List<MateriaModel> materias) {
            this.materias = materias;
        }
}
