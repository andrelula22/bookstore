package com.andrelula.bookstore.controller;

import com.andrelula.bookstore.domain.Livro;
import com.andrelula.bookstore.dtos.LivroDTO;
import com.andrelula.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro>findById(@PathVariable Integer id){
        Livro obj =  service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<LivroDTO>>findAll(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
        List<Livro> list = service.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PutMapping(value="/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value="/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}
