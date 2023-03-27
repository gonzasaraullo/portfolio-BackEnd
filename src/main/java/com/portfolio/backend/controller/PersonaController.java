package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
Controlador de la seccion "Persona" donde estara nombre, apellido, informacion de contacto, url a imagenes
del banner y de perfil.
*/

@CrossOrigin(origins = "https://portfolio-gonzalo-saraullo.web.app")
@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("/api/persona/traer")
    public List <Persona> getPersona() {
        return interPersona.getPersona();
    }
    
    @GetMapping("/api/persona/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return interPersona.findPersona(id);
    }

    @PostMapping("/api/persona/crear")
    public ResponseEntity<Object> createEducacion(@RequestBody Persona perso) {
        if(StringUtils.isBlank(perso.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if(StringUtils.isBlank(perso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
          if(StringUtils.isBlank(perso.getOcupacion())){
            return new ResponseEntity(new Mensaje("La ocupacion es obligatoria"), HttpStatus.BAD_REQUEST);
        } if(StringUtils.isBlank(perso.getTelefono())){
            return new ResponseEntity(new Mensaje("El numero de telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if(StringUtils.isBlank(perso.getUbicacion())){
            return new ResponseEntity(new Mensaje("La ubicacion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
          if(StringUtils.isBlank(perso.getUrlCv())){
            return new ResponseEntity(new Mensaje("La url al CV es obligatoria"), HttpStatus.BAD_REQUEST);
        }
           if(StringUtils.isBlank(perso.getUrlGit())){
            return new ResponseEntity(new Mensaje("La url a GitHub es obligatoria"), HttpStatus.BAD_REQUEST);
        }
            if(StringUtils.isBlank(perso.getUrlImagenBanner())){
            return new ResponseEntity(new Mensaje("La url a laa imagen del banner es obligatoria"), HttpStatus.BAD_REQUEST);
        }
           if(StringUtils.isBlank(perso.getUrlImagenPerfil())){
            return new ResponseEntity(new Mensaje("La url a la imagen de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        interPersona.savePersona(perso);
        return new ResponseEntity<>(new Result("La seccion 'persona' fue creada"), HttpStatus.OK);
    }

    @DeleteMapping("/api/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {

        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/api/persona/editar/{id}")
    public ResponseEntity<?> editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("ocupacion") String ocupacion,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("telefono")String telefono,
            @RequestParam("email") String email,
            @RequestParam("urlImagenPerfil")String urlImagenPerfil,
            @RequestParam("urlImagenBanner")String urlImagenBanner,
            @RequestParam("urlGit")String urlGit,
            @RequestParam("urlCv")String urlCv) {
        
        Persona perso = interPersona.findPersona(id);
        perso.setNombre(nombre);
        perso.setOcupacion(ocupacion);
        perso.setUbicacion(ubicacion);
        perso.setTelefono(telefono);
        perso.setEmail(email);
        perso.setUrlImagenPerfil(urlImagenPerfil);
        perso.setUrlImagenBanner(urlImagenBanner);
        perso.setUrlGit(urlGit);
        perso.setUrlCv(urlCv);
        
        if(StringUtils.isBlank(perso.getEmail())){
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if(StringUtils.isBlank(perso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
          if(StringUtils.isBlank(perso.getOcupacion())){
            return new ResponseEntity(new Mensaje("La ocupacion es obligatoria"), HttpStatus.BAD_REQUEST);
        } if(StringUtils.isBlank(perso.getTelefono())){
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         if(StringUtils.isBlank(perso.getUbicacion())){
            return new ResponseEntity(new Mensaje("La ubicacion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
          if(StringUtils.isBlank(perso.getUrlCv())){
            return new ResponseEntity(new Mensaje("La url al CV es obligatoria"), HttpStatus.BAD_REQUEST);
        }
           if(StringUtils.isBlank(perso.getUrlGit())){
            return new ResponseEntity(new Mensaje("La url a GitHub es obligatoria"), HttpStatus.BAD_REQUEST);
        }
            if(StringUtils.isBlank(perso.getUrlImagenBanner())){
            return new ResponseEntity(new Mensaje("La url a la imagen del banner es obligatoria"), HttpStatus.BAD_REQUEST);
        }
           if(StringUtils.isBlank(perso.getUrlImagenPerfil())){
            return new ResponseEntity(new Mensaje("La url a la imagen de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        interPersona.savePersona(perso);
        return new ResponseEntity(new Mensaje("La seccion 'persona' actualizada"),HttpStatus.OK);

    }
}
