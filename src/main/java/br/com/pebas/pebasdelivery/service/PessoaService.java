package br.com.pebas.pebasdelivery.service;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.form.PessoaForm;
import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import br.com.pebas.pebasdelivery.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaValidator pessoaValidator;
    public List<PessoaDto> findAll() {
        return pessoaRepository.findAll().stream().map(p -> new PessoaDto(p.getId(), p.getNome(), p.getCpfCnpj(), p.getEmail(), p.getTelefone())).toList();
    }
    public PessoaDto findById(UUID id) {
        return pessoaValidator.findById(id);
    }

    public PessoaDto registeringPerson(PessoaForm form) {
        Pessoa person = new Pessoa();
        person = person.newPerson(form);
        Pessoa personSaved = pessoaRepository.save(person);
        return new PessoaDto(personSaved.getId(), personSaved.getNome(), person.getCpfCnpj(), person.getEmail(), person.getTelefone());
    }


}
