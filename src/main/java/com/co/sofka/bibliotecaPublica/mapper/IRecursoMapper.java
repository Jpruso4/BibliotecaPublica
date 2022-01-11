package com.co.sofka.bibliotecaPublica.mapper;

import com.co.sofka.bibliotecaPublica.dto.RecursoDTO;
import com.co.sofka.bibliotecaPublica.model.Recurso;

import java.util.List;

public interface IRecursoMapper {

    Recurso mapFromDto(RecursoDTO recursoDTO);

    RecursoDTO mapFromCollection(Recurso recurso);

    List<RecursoDTO> mapListRecurso(List<Recurso> listRecursos);

    RecursoDTO mapPrestamo(RecursoDTO recursoDTO);
}
