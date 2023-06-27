package br.com.pebas.pebasdelivery.service;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.form.PessoaForm;
import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import br.com.pebas.pebasdelivery.repository.PessoaRepository;
import br.com.pebas.pebasdelivery.service.validators.PessoaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static br.com.pebas.pebasdelivery.Utils.StringUsefulMethods.removeNonNumber;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaValidator pessoaValidator;
    public List<PessoaDto> findAll() {
        return pessoaRepository.findByOrderByCreatedAtAsc().stream().map(p -> new PessoaDto(p.getId(), p.getNome(), p.getCpf(), p.getEmail(), p.getTelefone(), p.getCreatedAt())).toList();
    }
    public PessoaDto findById(UUID id) {
        Pessoa person = pessoaValidator.findById(id);
        return convertPersonToPersonDto(person);
    }

    private PessoaDto convertPersonToPersonDto(Pessoa person) {
        return Objects.nonNull(person)?new PessoaDto(person.getId(), person.getNome(), person.getCpf(), person.getEmail(), person.getTelefone(),person.getCreatedAt()):null;
    }

    public PessoaDto updateById(UUID id, PessoaForm form) {
        Pessoa person = pessoaValidator.findById(id);
        if (Objects.nonNull(form.getNome())) {
            person.setNome(form.getNome());
        }
        if (Objects.nonNull(form.getCpf())) {
            person.setCpf(form.getCpf());
        }
        if (Objects.nonNull(form.getGeneroEnum())) {
            person.setGeneroEnum(form.getGeneroEnum());
        }
        if (Objects.nonNull(form.getEmail())) {
            person.setEmail(form.getEmail());
        }
        if (Objects.nonNull(form.getTelefone())) {
            person.setTelefone(form.getTelefone());
        }
        person.setUpdatedAt(LocalDateTime.now());
        return convertPersonToPersonDto(pessoaRepository.save(person));
    }

    public PessoaDto registeringPerson(PessoaForm form) {
        CPFValidations(form.getCpf());
        form.setCpf(removeNonNumber(form.getCpf()));
        Pessoa person = new Pessoa();
        person = person.newPerson(form);
        Pessoa personSaved = pessoaRepository.save(person);
        return new PessoaDto(personSaved.getId(), personSaved.getNome(), person.getCpf(), person.getEmail(), person.getTelefone(), person.getCreatedAt());
    }

    private void CPFValidations(String cpf) {
        PessoaValidator.validCPF(cpf);
        pessoaValidator.validIfCPFIsAlreadyRegistered(cpf);
    }

    public void deletePerson(UUID id){
        Pessoa person = pessoaValidator.findById(id);
        if (Objects.nonNull(person)){
            pessoaRepository.deleteById(id);
        }
    }

}
