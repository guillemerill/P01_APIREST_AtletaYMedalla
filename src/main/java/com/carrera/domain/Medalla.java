package com.carrera.domain;

import javax.persistence.*;

@Entity
public class Medalla {
    /**
     * Las medallas tendrán los siguientes atributos: Id, Enumeración (Oro, Plata, Bronce), Especialidad, Competición.
     */

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoMedalla tipoMedalla;
    private String especialidad;
    private String competicion;
    @ManyToOne
    private Atleta atleta;

    // Constructors
    public Medalla(TipoMedalla tipoMedalla, String especialidad, String competicion, Atleta atleta) {
        this.tipoMedalla = tipoMedalla;
        this.especialidad = especialidad;
        this.competicion = competicion;
        this.atleta = atleta;
    }

    public Medalla() {
    }

    // Getters & Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }
    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }
    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    // Methods

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", tipoMedalla=" + tipoMedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medalla medalla = (Medalla) o;

        if (id != medalla.id) return false;
        if (tipoMedalla != medalla.tipoMedalla) return false;
        if (especialidad != null ? !especialidad.equals(medalla.especialidad) : medalla.especialidad != null)
            return false;
        if (competicion != null ? !competicion.equals(medalla.competicion) : medalla.competicion != null) return false;
        return atleta != null ? atleta.equals(medalla.atleta) : medalla.atleta == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tipoMedalla != null ? tipoMedalla.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (competicion != null ? competicion.hashCode() : 0);
        //result = 31 * result + (atleta != null ? atleta.hashCode() : 0);
        return result;
    }
}