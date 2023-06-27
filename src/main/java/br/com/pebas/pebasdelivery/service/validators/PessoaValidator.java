package br.com.pebas.pebasdelivery.service.validators;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.pebas.pebasdelivery.domain.model.Pessoa;
import br.com.pebas.pebasdelivery.repository.PessoaRepository;
import br.com.pebas.pebasdelivery.repository.jdbc.PessoaTempleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoaValidator {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaTempleteService pessoaTempleteService;

    public Pessoa findById(UUID id){
        Optional<Pessoa> person = pessoaRepository.findById(id);
        return person.orElse(null);
    }

    public static void validCPF(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        if(erros.size() > 0){
            throw new InvalidParameterException("There is invalid a cpf!");
        }
    }

    public void validIfCPFIsAlreadyRegistered(String cpf){
        if (pessoaTempleteService.checkExistenceCPF(cpf)){
            throw new InvalidParameterException("There is already a person with that cpf!");
        }
    }

}
