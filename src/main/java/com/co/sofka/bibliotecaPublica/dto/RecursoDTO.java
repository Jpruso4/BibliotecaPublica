package com.co.sofka.bibliotecaPublica.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDTO {

	private String id;
	private String nombre;
    private String tipo;
    private String tematica;
	private LocalDate fechaDePrestamo;
    private boolean estado;

}
