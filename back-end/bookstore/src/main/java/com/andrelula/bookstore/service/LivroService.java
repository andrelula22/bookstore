package com.andrelula.bookstore.service;

import com.andrelula.bookstore.domain.Livro;
import com.andrelula.bookstore.repositories.LivroRepository;
import com.andrelula.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}

