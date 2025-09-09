package com.Secretaria.Secretaria.Model;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;


@Entity
@Table(name ="alumnos")
public class AlumnoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int ano_lec;

    @Column( nullable = false)
    private int nroLeg;

    @Column( nullable = false)
    private Integer carrera;

    @Column(length = 10)
    private String DA_TipDoc;

    @Column(length = 10)
    private String dni;

    @Column(length = 20)
    private String DA_EstCiv;
    @Column(length = 40)
    private String DA_Ape;

    @Column(length = 40)
    private String DA_Nom;

    @Column(length = 20)
    private String DA_Sex;
    private LocalDate DA_FeNa;

    @Column(length = 30)
    private String DA_LocNa;

    @Column(length = 30)
    private String DA_PaisNa;

    @Column(length = 30)
    private String DA_DomCalle;

    @Column
    private Integer DA_DomNro;

    @Column
    private Integer DA_DomPiso;

    @Column(length = 6)
    private String DA_DomDpto;

    @Column(length = 20)
    private String DA_Prov;

    @Column(length = 20)
    private String DA_Distri;

    @Column(length = 20)
    private String DA_Loc;

    @Column
    private Integer DA_CodPost;

    @Column
    private Long DA_TelFij;

    @Column
    private Long DA_Cel;

    @Column
    private String DA_Correo;

    // ---- Título secundario ----
    private Boolean F_TitSec;

    @Column
    private Integer F_TitSecNo;

    @Column(length = 200)
    private String F_TitSecNo2;

    @Column(length = 30)
    private String F_TitSecSi_Titulo;

    @Column(length = 30)
    private String F_TitSecSi_Orientacion;

    @Column(length = 30)
    private String F_TitSecSi_Otorga;

    @Column
    private Integer F_TitSecSi_ano;

    @Column
    private Double F_TitSecSi_Promedio;

    private Boolean F_TitSecSi_Tramite;

    // ---- Laboral ----
    private Boolean Trabaja;

    @Column(length = 15)
    private String Tra_list;

    @Column(length = 100)
    private String Tra_hor;

    private Boolean Tra_PeJu;

    @Column(length = 100)
    private String Tra_Edu;

    @Column(length = 100)
    private String Tra_Edu_Desempeno;

    @Column(length = 100)
    private String Tra_Edu_Gestion;

    // ---- Familiar ----
    private Boolean SF_Solo;

    @Column(length = 5)
    private String SF_SoloNo;

    private Boolean SF_FCargo;

    @Column(length = 4)
    private String SF_FCargoSi;

    // ---- Becas / Planes ----
    @Column(length = 11)
    private String BePlPr;

    @Column(length = 20)
    private String BePlPrOtro;

    // ---- Prácticas culturales ----
    private Boolean PCC_Radio;
    private Boolean PCC_Tele;
    private Boolean PCC_Teatro;
    private Boolean PCC_Museo;
    private Boolean PCC_Conci;
    private Boolean PCC_Recit;
    private Boolean PCC_LecFr;

    @Column(length = 5)
    private String PCC_LecFrSi;

    @Column(length = 60)
    private String PCC_Otro;

    @Transient
    private Integer edad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAno_lec() {
        return ano_lec;
    }

    public void setAno_lec(int ano_lec) {
        this.ano_lec = ano_lec;
    }

    public int getNroLeg() {
        return nroLeg;
    }

    public void setNroLeg(int nroLeg) {
        this.nroLeg = nroLeg;
    }

    public Integer getCarrera() {
        return carrera;
    }

    public void setCarrera(Integer carrera) {
        this.carrera = carrera;
    }

    public String getDA_TipDoc() {
        return DA_TipDoc;
    }

    public void setDA_TipDoc(String dA_TipDoc) {
        DA_TipDoc = dA_TipDoc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDA_EstCiv() {
        return DA_EstCiv;
    }

    public void setDA_EstCiv(String dA_EstCiv) {
        DA_EstCiv = dA_EstCiv;
    }

    public String getDA_Ape() {
        return DA_Ape;
    }

    public void setDA_Ape(String dA_Ape) {
        DA_Ape = dA_Ape;
    }

    public String getDA_Nom() {
        return DA_Nom;
    }

    public void setDA_Nom(String dA_Nom) {
        DA_Nom = dA_Nom;
    }

    public String getDA_Sex() {
        return DA_Sex;
    }

    public void setDA_Sex(String dA_Sex) {
        DA_Sex = dA_Sex;
    }

    public LocalDate getDA_FeNa() {
        return DA_FeNa;
    }

    public void setDA_FeNa(LocalDate dA_FeNa) {
        DA_FeNa = dA_FeNa;
    }

    public String getDA_LocNa() {
        return DA_LocNa;
    }

    public void setDA_LocNa(String dA_LocNa) {
        DA_LocNa = dA_LocNa;
    }

    public String getDA_PaisNa() {
        return DA_PaisNa;
    }

    public void setDA_PaisNa(String dA_PaisNa) {
        DA_PaisNa = dA_PaisNa;
    }

    public String getDA_DomCalle() {
        return DA_DomCalle;
    }

    public void setDA_DomCalle(String dA_DomCalle) {
        DA_DomCalle = dA_DomCalle;
    }

    public Integer getDA_DomNro() {
        return DA_DomNro;
    }

    public void setDA_DomNro(Integer dA_DomNro) {
        DA_DomNro = dA_DomNro;
    }

    public Integer getDA_DomPiso() {
        return DA_DomPiso;
    }

    public void setDA_DomPiso(Integer dA_DomPiso) {
        DA_DomPiso = dA_DomPiso;
    }

    public String getDA_DomDpto() {
        return DA_DomDpto;
    }

    public void setDA_DomDpto(String dA_DomDpto) {
        DA_DomDpto = dA_DomDpto;
    }

    public String getDA_Prov() {
        return DA_Prov;
    }

    public void setDA_Prov(String dA_Prov) {
        DA_Prov = dA_Prov;
    }

    public String getDA_Distri() {
        return DA_Distri;
    }

    public void setDA_Distri(String dA_Distri) {
        DA_Distri = dA_Distri;
    }

    public String getDA_Loc() {
        return DA_Loc;
    }

    public void setDA_Loc(String dA_Loc) {
        DA_Loc = dA_Loc;
    }

    public Integer getDA_CodPost() {
        return DA_CodPost;
    }

    public void setDA_CodPost(Integer dA_CodPost) {
        DA_CodPost = dA_CodPost;
    }

    public Long getDA_TelFij() {
        return DA_TelFij;
    }

    public void setDA_TelFij(Long dA_TelFij) {
        DA_TelFij = dA_TelFij;
    }

    public Long getDA_Cel() {
        return DA_Cel;
    }

    public void setDA_Cel(Long dA_Cel) {
        DA_Cel = dA_Cel;
    }

    public String getDA_Correo() {
        return DA_Correo;
    }

    public void setDA_Correo(String dA_Correo) {
        DA_Correo = dA_Correo;
    }

    public Boolean getF_TitSec() {
        return F_TitSec;
    }

    public void setF_TitSec(Boolean f_TitSec) {
        F_TitSec = f_TitSec;
    }

    public Integer getF_TitSecNo() {
        return F_TitSecNo;
    }

    public void setF_TitSecNo(Integer f_TitSecNo) {
        F_TitSecNo = f_TitSecNo;
    }

    public String getF_TitSecNo2() {
        return F_TitSecNo2;
    }

    public void setF_TitSecNo2(String f_TitSecNo2) {
        F_TitSecNo2 = f_TitSecNo2;
    }

    public String getF_TitSecSi_Titulo() {
        return F_TitSecSi_Titulo;
    }

    public void setF_TitSecSi_Titulo(String f_TitSecSi_Titulo) {
        F_TitSecSi_Titulo = f_TitSecSi_Titulo;
    }

    public String getF_TitSecSi_Orientacion() {
        return F_TitSecSi_Orientacion;
    }

    public void setF_TitSecSi_Orientacion(String f_TitSecSi_Orientacion) {
        F_TitSecSi_Orientacion = f_TitSecSi_Orientacion;
    }

    public String getF_TitSecSi_Otorga() {
        return F_TitSecSi_Otorga;
    }

    public void setF_TitSecSi_Otorga(String f_TitSecSi_Otorga) {
        F_TitSecSi_Otorga = f_TitSecSi_Otorga;
    }

    public Integer getF_TitSecSi_ano() {
        return F_TitSecSi_ano;
    }

    public void setF_TitSecSi_ano(Integer f_TitSecSi_ano) {
        F_TitSecSi_ano = f_TitSecSi_ano;
    }

    public Double getF_TitSecSi_Promedio() {
        return F_TitSecSi_Promedio;
    }

    public void setF_TitSecSi_Promedio(Double f_TitSecSi_Promedio) {
        F_TitSecSi_Promedio = f_TitSecSi_Promedio;
    }

    public Boolean getF_TitSecSi_Tramite() {
        return F_TitSecSi_Tramite;
    }

    public void setF_TitSecSi_Tramite(Boolean f_TitSecSi_Tramite) {
        F_TitSecSi_Tramite = f_TitSecSi_Tramite;
    }

    public Boolean getTrabaja() {
        return Trabaja;
    }

    public void setTrabaja(Boolean trabaja) {
        Trabaja = trabaja;
    }

    public String getTra_list() {
        return Tra_list;
    }

    public void setTra_list(String tra_list) {
        Tra_list = tra_list;
    }

    public String getTra_hor() {
        return Tra_hor;
    }

    public void setTra_hor(String tra_hor) {
        Tra_hor = tra_hor;
    }

    public Boolean getTra_PeJu() {
        return Tra_PeJu;
    }

    public void setTra_PeJu(Boolean tra_PeJu) {
        Tra_PeJu = tra_PeJu;
    }

    public String getTra_Edu() {
        return Tra_Edu;
    }

    public void setTra_Edu(String tra_Edu) {
        Tra_Edu = tra_Edu;
    }

    public String getTra_Edu_Desempeno() {
        return Tra_Edu_Desempeno;
    }

    public void setTra_Edu_Desempeno(String tra_Edu_Desempeno) {
        Tra_Edu_Desempeno = tra_Edu_Desempeno;
    }

    public String getTra_Edu_Gestion() {
        return Tra_Edu_Gestion;
    }

    public void setTra_Edu_Gestion(String tra_Edu_Gestion) {
        Tra_Edu_Gestion = tra_Edu_Gestion;
    }

    public Boolean getSF_Solo() {
        return SF_Solo;
    }

    public void setSF_Solo(Boolean sF_Solo) {
        SF_Solo = sF_Solo;
    }

    public String getSF_SoloNo() {
        return SF_SoloNo;
    }

    public void setSF_SoloNo(String sF_SoloNo) {
        SF_SoloNo = sF_SoloNo;
    }

    public Boolean getSF_FCargo() {
        return SF_FCargo;
    }

    public void setSF_FCargo(Boolean sF_FCargo) {
        SF_FCargo = sF_FCargo;
    }

    public String getSF_FCargoSi() {
        return SF_FCargoSi;
    }

    public void setSF_FCargoSi(String sF_FCargoSi) {
        SF_FCargoSi = sF_FCargoSi;
    }

    public String getBePlPr() {
        return BePlPr;
    }

    public void setBePlPr(String bePlPr) {
        BePlPr = bePlPr;
    }

    public String getBePlPrOtro() {
        return BePlPrOtro;
    }

    public void setBePlPrOtro(String bePlPrOtro) {
        BePlPrOtro = bePlPrOtro;
    }

    public Boolean getPCC_Radio() {
        return PCC_Radio;
    }

    public void setPCC_Radio(Boolean pCC_Radio) {
        PCC_Radio = pCC_Radio;
    }

    public Boolean getPCC_Tele() {
        return PCC_Tele;
    }

    public void setPCC_Tele(Boolean pCC_Tele) {
        PCC_Tele = pCC_Tele;
    }

    public Boolean getPCC_Teatro() {
        return PCC_Teatro;
    }

    public void setPCC_Teatro(Boolean pCC_Teatro) {
        PCC_Teatro = pCC_Teatro;
    }

    public Boolean getPCC_Museo() {
        return PCC_Museo;
    }

    public void setPCC_Museo(Boolean pCC_Museo) {
        PCC_Museo = pCC_Museo;
    }

    public Boolean getPCC_Conci() {
        return PCC_Conci;
    }

    public void setPCC_Conci(Boolean pCC_Conci) {
        PCC_Conci = pCC_Conci;
    }

    public Boolean getPCC_Recit() {
        return PCC_Recit;
    }

    public void setPCC_Recit(Boolean pCC_Recit) {
        PCC_Recit = pCC_Recit;
    }

    public Boolean getPCC_LecFr() {
        return PCC_LecFr;
    }

    public void setPCC_LecFr(Boolean pCC_LecFr) {
        PCC_LecFr = pCC_LecFr;
    }

    public String getPCC_LecFrSi() {
        return PCC_LecFrSi;
    }

    public void setPCC_LecFrSi(String pCC_LecFrSi) {
        PCC_LecFrSi = pCC_LecFrSi;
    }

    public String getPCC_Otro() {
        return PCC_Otro;
    }

    public void setPCC_Otro(String pCC_Otro) {
        PCC_Otro = pCC_Otro;
    }

    public int getEdad() {
        if (DA_FeNa == null) {
        return 0;
        }
        return Period.between(DA_FeNa, LocalDate.now()).getYears();
    }
}
