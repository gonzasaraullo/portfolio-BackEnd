package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String ocupacion;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String telefono;
    @NotBlank
    private String email;
    @NotBlank
    private String urlImagenPerfil;
    @NotBlank
    private String urlImagenBanner;
    @NotBlank
    private String urlGit;
    @NotBlank
    private String urlCv;

    public Persona() {
    }

    public Persona(Long id, String nombre, String ocupacion, String ubicacion, String telefono, String email, String urlImagenPerfil, String urlImagenBanner, String urlGit, String urlCv) {
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.email = email;
        this.urlImagenPerfil = urlImagenPerfil;
        this.urlImagenBanner = urlImagenBanner;
        this.urlGit = urlGit;
        this.urlCv = urlCv;
    }

}
