package com.co.sofka.bibliotecaPublica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.co.sofka.bibliotecaPublica.model.Recurso;

@Repository
public interface IRecursoRepository extends MongoRepository<Recurso, String>{

}
