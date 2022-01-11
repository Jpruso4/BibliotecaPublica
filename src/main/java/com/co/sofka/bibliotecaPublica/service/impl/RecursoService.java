package com.co.sofka.bibliotecaPublica.service.impl;

import com.co.sofka.bibliotecaPublica.dto.RecursoDTO;
import com.co.sofka.bibliotecaPublica.mapper.IRecursoMapper;
import com.co.sofka.bibliotecaPublica.model.Recurso;
import com.co.sofka.bibliotecaPublica.repository.IRecursoRepository;
import com.co.sofka.bibliotecaPublica.service.IRecursoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecursoService implements IRecursoService {

    private final IRecursoMapper iRecursoMapper;
    private final IRecursoRepository iRecursoRepository;

    public RecursoService(IRecursoMapper iRecursoMapper, IRecursoRepository iRecursoRepository) {
        this.iRecursoMapper = iRecursoMapper;
        this.iRecursoRepository = iRecursoRepository;
    }

    @Override
    public RecursoDTO obtenerRecursoId(String id) {
        Recurso recurso = iRecursoRepository.findById(id).orElseThrow(() -> new RuntimeException("El recurso no fue encontrado"));
        return iRecursoMapper.mapFromCollection(recurso);
    }

    @Override
    public List<RecursoDTO> obtenerRecursos() {
        List<Recurso> listRecurso = iRecursoRepository.findAll();
        return iRecursoMapper.mapListRecurso(listRecurso);
    }

    @Override
    public RecursoDTO crearRecurso(RecursoDTO recursoDTO) {
        Recurso recurso = iRecursoMapper.mapFromDto(recursoDTO);
        return iRecursoMapper.mapFromCollection(iRecursoRepository.save(recurso));
    }

    @Override
    public RecursoDTO modificarRecurso(RecursoDTO recursoDTO) {
        Recurso recurso = iRecursoMapper.mapFromDto(recursoDTO);
        iRecursoRepository.findById(recurso.getId()).orElseThrow(() -> new RuntimeException("El recurso no fue encontrado"));
        return iRecursoMapper.mapFromCollection(iRecursoRepository.save(recurso));
    }

    @Override
    public String eliminarRecurso(String id) {
        iRecursoRepository.deleteById(id);
        return "El recurso fue eliminado con exito";
    }

    @Override
    public String consultarDisponibilidad(String id) {
        RecursoDTO recurso = obtenerRecursoId(id);
        if(!recurso.isEstado()){
            return "El reccurso no se encuentra disponible en el momento y la fecha del prestamo del ejemplar fue: " + recurso.getFechaDePrestamo();
        }
        return "El reccurso se encuentra disponible";
    }

    @Override
    public String prestarRecurso(String id) {
        RecursoDTO recurso = obtenerRecursoId(id);
        if(recurso.isEstado()){
            recurso.setEstado(false);
            recurso.setFechaDePrestamo(LocalDate.now());
            modificarRecurso(recurso);
            return "El prestamo se ha hecho correctamente " + recurso.getFechaDePrestamo();
        }else
            return "El recurso no se encuentra disponible";
    }

    @Override
    public String devolverRecurso(String id) {
        RecursoDTO recurso = obtenerRecursoId(id);
        if(!recurso.isEstado()){
            recurso.setEstado(true);
            modificarRecurso(iRecursoMapper.mapPrestamo(recurso));
            return "El reccurso se ha devuelto con exito";
        }
        return "El recurso no se puede devolver ya que no se ha prestado";
    }

}
