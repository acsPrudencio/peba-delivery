package br.com.peba.pebadelivery.service;

import br.com.peba.pebadelivery.domain.dto.PessoaDto;
import br.com.peba.pebadelivery.domain.form.PessoaForm;
import br.com.peba.pebadelivery.domain.model.Pessoa;
import br.com.peba.pebadelivery.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    public List<PessoaDto> findAll() {
        return pessoaRepository.findAll().stream().map(p -> new PessoaDto(p.getNome(), p.getCpfCnpj(), p.getEmail(), p.getTelefone())).toList();
    }

    public PessoaDto registeringPerson(PessoaForm form) {
        Pessoa person = newPerson(form);
        Pessoa personSaved = pessoaRepository.save(person);
        return new PessoaDto(personSaved.getNome(), person.getCpfCnpj(), person.getEmail(), person.getTelefone());
    }

    private Pessoa newPerson(PessoaForm form) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(form.getNome());
        pessoa.setCpfCnpj(form.getCpfCnpj());
        pessoa.setGeneroEnum(form.getGeneroEnum());
        pessoa.setEmail(form.getEmail());
        pessoa.setTelefone(form.getTelefone());
        return pessoa;
    }
}
