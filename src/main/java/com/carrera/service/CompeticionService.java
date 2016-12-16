package com.carrera.service;

import com.carrera.domain.Atleta;
import com.carrera.domain.Medalla;
import com.carrera.domain.TipoMedalla;
import com.carrera.repository.AtletaRepository;
import com.carrera.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompeticionService {

    @Autowired
    private MedallaRepository medallas;
    @Autowired
    private AtletaRepository atletas;



    public void creaClasificados() {

        Atleta a1e1 = new Atleta("Eliud", "Kipchoge", "Kenia", LocalDate.of(1984, 11, 5));
        atletas.save(a1e1);
        Atleta a2e1 = new Atleta("Feyisa", "Lilesa", "Etiopía", LocalDate.of(1990, 2, 1));
        atletas.save(a2e1);
        Atleta a3e1 = new Atleta("Galen", "Rupp", "EEUU", LocalDate.of(1986, 5, 8));
        atletas.save(a3e1);
        Atleta a1e2 = new Atleta("Kerron", "Clement", "EEUU", LocalDate.of(1985, 10, 31));
        atletas.save(a1e2);
        Atleta a2e2 = new Atleta("Boniface Mucheru", "Tumuti", "Kenia", LocalDate.of(1992, 5, 2));
        atletas.save(a2e2);
        Atleta a3e2 = new Atleta("Yasmani", "Copello", "Turquia", LocalDate.of(1987, 4, 15));
        atletas.save(a3e2);
        Atleta a1e3 = new Atleta("Zhen", "Wang", "China", LocalDate.of(1991, 7, 24));
        atletas.save(a1e3);
        Atleta a2e3 = new Atleta("Zelin", "Cai ", "China", LocalDate.of(1991, 4, 11));
        atletas.save(a2e3);
        Atleta a3e3 = new Atleta("Dane", "BIRD-SMITH", "Australia", LocalDate.of(1992, 7, 15));
        atletas.save(a3e3);

        Medalla m1e1 = new Medalla(TipoMedalla.Oro, "Maratón", "Rio 2016", a1e1);
        medallas.save(m1e1);
        Medalla m2e1 = new Medalla(TipoMedalla.Plata, "Maratón", "Rio 2016", a2e1);
        medallas.save(m2e1);
        Medalla m3e1 = new Medalla(TipoMedalla.Bronce, "Maratón", "Rio 2016", a3e1);
        medallas.save(m3e1);
        Medalla m1e2 = new Medalla(TipoMedalla.Oro, "Vallas", "Rio 2016", a1e2);
        medallas.save(m1e2);
        Medalla m2e2 = new Medalla(TipoMedalla.Plata, "Vallas", "Rio 2016", a2e2);
        medallas.save(m2e2);
        Medalla m3e2 = new Medalla(TipoMedalla.Bronce, "Vallas", "Rio 2016", a3e2);
        medallas.save(m3e2);
        Medalla m1e3 = new Medalla(TipoMedalla.Oro, "Marcha", "Rio 2016", a1e3);
        medallas.save(m1e3);
        Medalla m2e3 = new Medalla(TipoMedalla.Plata, "Marcha", "Rio 2016", a2e3);
        medallas.save(m2e3);
        Medalla m3e3 = new Medalla(TipoMedalla.Bronce, "Marcha", "Rio 2016", a3e3);
        medallas.save(m3e3);
    }

}