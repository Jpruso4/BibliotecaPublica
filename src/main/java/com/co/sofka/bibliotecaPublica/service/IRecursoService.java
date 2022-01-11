package com.co.sofka.bibliotecaPublica.service;

import com.co.sofka.bibliotecaPublica.dto.RecursoDTO;

import java.util.List;

public interface IRecursoService {

    RecursoDTO obtenerRecursoId(String id);

    List<RecursoDTO> obtenerRecursos();

    RecursoDTO crearRecurso(RecursoDTO recursoDTO);

    RecursoDTO modificarRecurso(RecursoDTO recursoDTO);

    String eliminarRecurso(String id);

    String consultarDisponibilidad(String id);

    String prestarRecurso(String id);

    String devolverRecurso(String id);
}
