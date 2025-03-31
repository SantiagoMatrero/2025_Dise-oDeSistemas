package org.example;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Alumno {
    private String nombre;
    private String apellido;
    private List<Materia> materias;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido= apellido;
        this.materias = new ArrayList<>();
    }

    public void agregarMateriaAprobada(Materia materia) {
        if (!materias.contains(materia)) {
            materias.add(materia);
        }
    }

    public List<Materia> getMateriasAprobadas() {
        return new ArrayList<>(materias);
    }
}

class Materia {
    private String nombre;
    private List<Materia>correlativas;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas != null ? new ArrayList<>(correlativas) : new ArrayList<>();
    }

    public boolean cumpleCorrelativas(List<Materia>materias){
        return materias.containsAll(correlativas);
    }
}

class Inscripcion {
    private List<Materia>materiasACursar;
    private boolean fueAprobada;
    private Alumno alumno;
    private LocalDateTime fechaDeEvaluacion;

    public Inscripcion(List<Materia>materiasACursar, Alumno alumno, LocalDateTime fechaDeEvaluacion) {
        this.materiasACursar = materiasACursar;
        this.alumno = alumno;
        this.fechaDeEvaluacion = fechaDeEvaluacion;
        this.fueAprobada = false;
    }

    public boolean aprobada() {
        for (Materia materia : materiasACursar) {
            if (!materia.cumpleCorrelativas(alumno.getMateriasAprobadas())) {
                return false;
            }
        }
        return true;
    }
}