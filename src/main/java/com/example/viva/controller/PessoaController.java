package com.example.viva.controller;

import com.example.viva.model.domain.Pessoa;
import com.example.viva.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
//@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Criar uma pessoa
    @PostMapping("/createPerson")
    public Pessoa createPerson(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Obter todas as pessoas
    @GetMapping("/getAllPeople")
    public List<Pessoa> getAllPeople() {
        return pessoaRepository.findAll();
    }

    // Obter uma pessoa por userName
    @GetMapping("/getPersonByUserName/{userName}")
    public Pessoa getPersonByUserName(@PathVariable String userName) {
        return pessoaRepository.findByUserName(userName);
    }

    // Atualizar informações de uma pessoa
    @PutMapping("/updatePerson/{id}")
    public Pessoa updatePerson(@PathVariable String id, @RequestBody Pessoa pessoa) {
        Pessoa existingPerson = pessoaRepository.findById(id).orElse(null);

        if (existingPerson != null) {
            // Atualiza apenas as propriedades desejadas
            existingPerson.setNome(pessoa.getNome());
            existingPerson.setDocumento(pessoa.getDocumento());
            existingPerson.setTelefone(pessoa.getTelefone());
            existingPerson.setEndereco(pessoa.getEndereco());

            return pessoaRepository.save(existingPerson);
        } else {
            // Retorna null ou lança uma exceção, dependendo dos requisitos
            return null;
        }
    }

    // Deletar uma pessoa
    @DeleteMapping("/deletePerson/{id}")
    public void deletePerson(@PathVariable String id) {
        pessoaRepository.deleteById(id);
    }

    // Mapeamento para exibir a página de perfil
    @GetMapping("/perfil")
    public Pessoa mostrarPerfil(Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            return pessoaRepository.findByUserName(username);
        } else {
            // Retorna null ou lança uma exceção, dependendo dos requisitos
            return null;
        }
    }

}
