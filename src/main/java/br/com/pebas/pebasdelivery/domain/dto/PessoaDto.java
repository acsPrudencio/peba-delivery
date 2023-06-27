package br.com.pebas.pebasdelivery.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PessoaDto {
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    public PessoaDto(UUID id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
}
