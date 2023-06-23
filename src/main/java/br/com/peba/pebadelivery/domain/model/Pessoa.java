package br.com.peba.pebadelivery.domain.model;

import br.com.peba.pebadelivery.domain.enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(length = 100, name = "nome", nullable = false)
    private String nome;
    @Column(length = 14, name = "cpf_cnpj", nullable = false)
    private String cpfCnpj;
    @Enumerated(EnumType.ORDINAL)
    @Column(length = 10, name = "genero", nullable = false)
    private GeneroEnum generoEnum;
    @Column(length = 100, name = "email")
    private String email;
    @Column(length = 20, name = "telefone")
    private String telefone;

}
