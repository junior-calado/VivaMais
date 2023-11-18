package com.example.viva.model.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "Pessoa")
@Document(collection = "Pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pessoa {


    @Column(nullable = false)
    private String documento;


    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private String telefone;


    @Column(nullable = false)
    private String endereco;

    @Id
    private String userName;


    @Column(nullable = false)
    private String password;
}

