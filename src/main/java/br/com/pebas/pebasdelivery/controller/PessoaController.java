package br.com.pebas.pebasdelivery.controller;

import br.com.pebas.pebasdelivery.domain.dto.PessoaDto;
import br.com.pebas.pebasdelivery.domain.form.PessoaForm;
import br.com.pebas.pebasdelivery.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Retorna todas as pessoas cadastradas no sistema.")
    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @Operation(summary = "Busca uma pessoa a partir de seu id.")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> findById(@RequestParam UUID id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @Operation(summary = "Cadastra uma pessoa.")
    @PostMapping
    public ResponseEntity<PessoaDto> registeringPerson(@RequestBody @Valid PessoaForm form){
        return ResponseEntity.ok(pessoaService.registeringPerson(form));
    }

    @Operation(summary = "Atualiza uma pessoa a partir de seu id.")
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> updateById(@RequestParam UUID id, @RequestBody @Valid PessoaForm form){
        return ResponseEntity.ok(pessoaService.updateById(id, form));
    }

    @Operation(summary = "Excluir uma pessoa a partir de seu id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        pessoaService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
