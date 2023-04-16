package com.luisn.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
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
}
