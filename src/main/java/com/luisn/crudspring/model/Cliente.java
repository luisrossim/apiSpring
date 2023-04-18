package com.luisn.crudspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String categoria;



}
