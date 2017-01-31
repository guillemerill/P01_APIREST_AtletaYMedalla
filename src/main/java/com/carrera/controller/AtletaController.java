package com.carrera.controller;

import com.carrera.domain.Atleta;
import com.carrera.domain.TipoMedalla;
import com.carrera.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/atleta")
public class  AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    // CRUD
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atleta createAtleta(@RequestBody Atleta atleta){
        return atletaRepository.save(atleta);
    }

    @GetMapping
    public List<Atleta> getAllAtletas(){
        return atletaRepository.findAll();
    }

    @PutMapping
    public Atleta updateAtleta(@RequestBody Atleta atleta){
        return atletaRepository.save(atleta);
    }

    @DeleteMapping("/{id}")
    public void deleteAtleta(@PathVariable Long id){
        Atleta atleta = atletaRepository.findOne(id);
        if(atleta != null ) atletaRepository.delete(id);
    }


    @GetMapping("/atleta/{apellido}")
    public Atleta getAtleta(@PathVariable String nombre) {
        return atletaRepository.getAtleta(nombre);
    }

    // 1. Devolver todos los Atletas de una nacionalidad determinada
    @GetMapping("/nacionalidad/{nacionalidad}")
    public List<Atleta> atletasFromNacionalidad(@PathVariable String nacionalidad){
        // Query
        return atletaRepository.getByNacionalidad(nacionalidad);
        // Version Java 8: return atletaRepository.findAll().stream().filter(a -> a.getNacionalidad().equals(nacionalidad)).collect(Collectors.toList());
    }

    // 2. Devolver todos los atletas que hayan nacido en una fecha anterior a una fecha determinada.
    @GetMapping("/nacimientoBefore/{fecha}")
    public List<Atleta> atletasBeforeFecha(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate fecha){
        // Query
        return atletaRepository.findByNacimientoBefore(fecha);

        // Version Java 8: return atletaRepository.findAll().stream().filter(a -> a.getNacimiento() < fecha).collect(Collectors.toList());
    }


    // 3. Retornar todos los atletas agrupados por nacionalidad mediante un Map<String, List <Atleta>>;
    @GetMapping("/atletasByNacionalidad")
    public Map<String, List<Atleta>> groupByNacionalidad(){
        return atletaRepository.findAll().parallelStream().collect(Collectors.groupingBy(Atleta::getNacionalidad));

    }

    // 4. Retornar todos los atletas agrupados por tipo de medalla mediante un Map<TipoMedalla, List<Atleta>>;
    @GetMapping("/atletasByTipoMedalla")
    public Map<TipoMedalla, List<Atleta>> groupByTipoMedalla() {
        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(atleta -> {
                    if (atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Oro)){
                        return TipoMedalla.Oro;
                    } else if (atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Plata)){
                        return TipoMedalla.Plata;
                    } else if (atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Bronce)){
                        return TipoMedalla.Bronce;
                    } else {
                        return TipoMedalla.Ninguna;
                    }
                }));
    }



}
