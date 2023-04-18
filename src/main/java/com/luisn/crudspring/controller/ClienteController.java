package com.luisn.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisn.crudspring.model.Cliente;
import com.luisn.crudspring.repository.ClienteRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente registrocliente){
        //System.out.println(registrocliente.getName());
        //return clienteRepository.save(registrocliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(registrocliente));
    }
}
