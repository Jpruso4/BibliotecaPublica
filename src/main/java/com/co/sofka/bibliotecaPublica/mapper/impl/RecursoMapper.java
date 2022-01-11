package com.co.sofka.bibliotecaPublica.mapper.impl;

import com.co.sofka.bibliotecaPublica.dto.RecursoDTO;
import com.co.sofka.bibliotecaPublica.mapper.IRecursoMapper;
import com.co.sofka.bibliotecaPublica.model.Recurso;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class RecursoMapper implements IRecursoMapper {

    public Recurso mapFromDto(RecursoDTO recursoDTO){
        Recurso recurso = new Recurso();
        recurso.setId(recursoDTO.getId());
        recurso.setNombre(recursoDTO.getNombre());
        recurso.setTipo(recursoDTO.getTipo());
        recurso.setTematica(recursoDTO.getTematica());
        recurso.setFechaDePrestamo(recursoDTO.getFechaDePrestamo());
        recurso.setEstado(recursoDTO.isEstado());
        return recurso;
    }

    public RecursoDTO mapFromCollection(Recurso recurso){
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setId(recurso.getId());
        recursoDTO.setNombre(recurso.getNombre());
        recursoDTO.setTipo(recurso.getTipo());
        recursoDTO.setTematica(recurso.getTematica());
        recursoDTO.setFechaDePrestamo(recurso.getFechaDePrestamo());
        recursoDTO.setEstado(recurso.isEstado());
        return recursoDTO;
    }

    @Override
    public List<RecursoDTO> mapListRecurso(List<Recurso> listRecursos) {
        List<RecursoDTO> listRecursosDTO = new LinkedList<>();
        for (Recurso recurso : listRecursos){
            listRecursosDTO.add(mapFromCollection(recurso));
        }
        return listRecursosDTO;
    }

    @Override
    public RecursoDTO mapPrestamo(RecursoDTO recursoDTO) {
        RecursoDTO recurso = new RecursoDTO();
        recurso.setId(recursoDTO.getId());
        recurso.setNombre(recursoDTO.getNombre());
        recurso.setTipo(recursoDTO.getTipo());
        recurso.setTematica(recursoDTO.getTematica());
        recurso.setEstado(recursoDTO.isEstado());
        return recurso;
    }
}
