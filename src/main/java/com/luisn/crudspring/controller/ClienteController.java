package com.luisn.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorID(@PathVariable long id) {
        return clienteRepository.findById(id)
            .map(registro -> ResponseEntity.ok().body(registro))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente registrocliente) {
        //System.out.println(registrocliente.getName());
        //return clienteRepository.save(registrocliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(registrocliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable long id, @RequestBody Cliente registrocliente) {

        return clienteRepository.findById(id)
            .map(registrobusca -> {
                registrobusca.setName(registrocliente.getName());
                registrobusca.setIdade(registrocliente.getIdade());
                registrobusca.setCidade(registrocliente.getCidade());
                registrobusca.setCategoria(registrocliente.getCategoria());
                Cliente atualizado = clienteRepository.save(registrobusca);
                return ResponseEntity.ok().body(atualizado);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Hard Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        return clienteRepository.findById(id)
        .map( registrobusca -> {
            clienteRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
    }

    /*
     * Caso nao queria remover no estilo hard delete (remocao fisica), o deletemapping ira alterar um campo
     * de status do cliente para inativo, por exemplo. Assim ele permanecerá na base de dados.
     */
}
