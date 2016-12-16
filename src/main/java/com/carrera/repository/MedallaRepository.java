package com.carrera.repository;

import com.carrera.domain.Medalla;
import com.carrera.domain.TipoMedalla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedallaRepository extends JpaRepository<Medalla, Long> {

}