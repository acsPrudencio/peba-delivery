package br.com.pebas.pebasdelivery.service;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import br.com.pebas.pebasdelivery.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoaValidator {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaDto findById(UUID id){
        Optional<Pessoa> person = pessoaRepository.findById(id);
        return person.isPresent()?new PessoaDto(person.get().getId(), person.get().getNome(), person.get().getCpfCnpj(), person.get().getEmail(), person.get().getTelefone()):null;
    }
}
