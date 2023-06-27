package br.com.pebas.pebasdelivery.controller;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.form.PessoaForm;
import br.com.pebas.pebasdelivery.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findById(@RequestParam UUID id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PessoaDto> registeringPerson(@RequestBody @Valid PessoaForm form){
        return ResponseEntity.ok(pessoaService.registeringPerson(form));
    }
}
