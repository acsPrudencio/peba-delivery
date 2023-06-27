package br.com.pebas.pebasdelivery.service;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.form.PessoaForm;
import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import br.com.pebas.pebasdelivery.repository.PessoaRepository;
import br.com.pebas.pebasdelivery.service.validators.PessoaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static br.com.pebas.pebasdelivery.Utils.StringUsefulMethods.removeNonNumber;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaValidator pessoaValidator;
    public List<PessoaDto> findAll() {
        return pessoaRepository.findAll().stream().map(p -> new PessoaDto(p.getId(), p.getNome(), p.getCpf(), p.getEmail(), p.getTelefone())).toList();
    }
    public PessoaDto findById(UUID id) {
        return pessoaValidator.findById(id);
    }

    public PessoaDto registeringPerson(PessoaForm form) {
        CPFValidations(form.getCpf());
        form.setCpf(removeNonNumber(form.getCpf()));
        Pessoa person = new Pessoa();
        person = person.newPerson(form);
        Pessoa personSaved = pessoaRepository.save(person);
        return new PessoaDto(personSaved.getId(), personSaved.getNome(), person.getCpf(), person.getEmail(), person.getTelefone());
    }

    private void CPFValidations(String cpf) {
        PessoaValidator.validCPF(cpf);
        pessoaValidator.validIfCPFIsAlreadyRegistered(cpf);
    }




}
