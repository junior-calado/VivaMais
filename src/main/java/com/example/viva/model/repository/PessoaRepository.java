package com.example.viva.model.repository;

import com.example.viva.model.domain.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String > {

    Pessoa findByUserName(String userName);

}
