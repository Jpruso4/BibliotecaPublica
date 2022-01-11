package com.co.sofka.bibliotecaPublica.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recurso {

    @Id
    private String id;
    private String nombre;
    private String tipo;
    private String tematica;
    private LocalDate fechaDePrestamo;
    private boolean estado;

}
