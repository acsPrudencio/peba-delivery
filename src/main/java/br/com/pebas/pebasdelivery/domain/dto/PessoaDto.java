package br.com.pebas.pebasdelivery.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PessoaDto {
    private LocalDateTime createdAt;
    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    public PessoaDto(UUID id, String nome, String cpf, String email, String telefone, LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
}
