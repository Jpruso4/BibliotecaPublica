package com.co.sofka.bibliotecaPublica.controller;

import com.co.sofka.bibliotecaPublica.dto.RecursoDTO;
import com.co.sofka.bibliotecaPublica.service.IRecursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class RecursoController {
	
	private final IRecursoService iRecursoService;

    public RecursoController(IRecursoService iRecursoService) {
        this.iRecursoService = iRecursoService;
    }

    @GetMapping("/recursos/{id}")
    public ResponseEntity<RecursoDTO> obtenerRecursoId(@PathVariable ("id") String id){
        return new ResponseEntity(iRecursoService.obtenerRecursoId(id), HttpStatus.OK);
    }

    @GetMapping("/recursos")
    public ResponseEntity<List<RecursoDTO>> obtenerRecursos(){
        return new ResponseEntity(iRecursoService.obtenerRecursos(), HttpStatus.OK);
    }

    @PostMapping("/recursos/crear")
    public ResponseEntity<RecursoDTO> crearRecurso(@RequestBody RecursoDTO recursoDTO){
        return new ResponseEntity(iRecursoService.crearRecurso(recursoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/recursos/modificar")
    public ResponseEntity<RecursoDTO> modificarRecurso(@RequestBody RecursoDTO recursoDTO){
        return new ResponseEntity(iRecursoService.modificarRecurso(recursoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/recursos/eliminar/{id}")
    public ResponseEntity<RecursoDTO> eliminarRecurso(@PathVariable("id") String id){
        return new ResponseEntity(iRecursoService.eliminarRecurso(id), HttpStatus.OK);
    }

    @GetMapping("/recursos/disponibilidad/{id}")
    public ResponseEntity<RecursoDTO> consultarDisponibilidad(@PathVariable("id") String id){
        return new ResponseEntity(iRecursoService.consultarDisponibilidad(id), HttpStatus.OK);
    }

    @GetMapping("/recursos/prestarRecurso/{id}")
    public ResponseEntity<RecursoDTO> prestarRecurso(@PathVariable("id") String id){
        return new ResponseEntity(iRecursoService.prestarRecurso(id), HttpStatus.OK);
    }

    @GetMapping("/recursos/devolverRecurso/{id}")
    public ResponseEntity<RecursoDTO> devolverRecurso(@PathVariable("id") String id){
        return new ResponseEntity(iRecursoService.devolverRecurso(id), HttpStatus.OK);
    }
}
