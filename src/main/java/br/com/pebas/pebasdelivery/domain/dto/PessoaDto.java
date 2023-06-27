package br.com.pebas.pebasdelivery.domain.dto;

import lombok.Data;

@Data
public class PessoaDto {
    private String nome;
    private String cpfCnpj;
    private String email;
    private String telefone;
    public PessoaDto(String nome, String cpfCnpj, String email, String telefone) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.telefone = telefone;
    }
}
