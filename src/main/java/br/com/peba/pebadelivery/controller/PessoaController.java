package br.com.peba.pebadelivery.controller;

import br.com.peba.pebadelivery.domain.dto.PessoaDto;
import br.com.peba.pebadelivery.domain.form.PessoaForm;
import br.com.peba.pebadelivery.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;
    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaDto> registeringPerson(@RequestBody @Valid PessoaForm form){
        return ResponseEntity.ok(pessoaService.registeringPerson(form));
    }
}
