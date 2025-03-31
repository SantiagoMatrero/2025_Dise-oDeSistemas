package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

class InscripcionTest {

    @Test
    void testInscripcionAprobada() {
        Materia algoritmos = new Materia("Algoritmos", null);
        Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos));
        Materia diseño = new Materia("Diseño", List.of(paradigmas));

        Alumno alumno = new Alumno("Nicolas", "Moretti");
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(paradigmas);

        Inscripcion inscripcion = new Inscripcion(List.of(diseño), alumno, LocalDateTime.now());

        assertTrue(inscripcion.aprobada(), "El alumno debería poder inscribirse en Diseño");
    }

    @Test
    void testInscripcionRechazada() {
        Materia algoritmos = new Materia("Algoritmos", null);
        Materia paradigmas = new Materia("Paradigmas", List.of(algoritmos));
        Materia diseño = new Materia("Diseño", List.of(paradigmas));

        Alumno alumno = new Alumno("Agustin", "Lopez");
        alumno.agregarMateriaAprobada(algoritmos);

        Inscripcion inscripcion = new Inscripcion(List.of(diseño), alumno, LocalDateTime.now());

        assertFalse(inscripcion.aprobada(), "El alumno NO debería poder inscribirse en Diseño");
    }
}
