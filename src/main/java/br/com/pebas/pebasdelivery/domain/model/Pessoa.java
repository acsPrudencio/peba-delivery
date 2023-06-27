package br.com.pebas.pebasdelivery.domain.model;

import br.com.pebas.pebasdelivery.domain.enums.GeneroEnum;
import br.com.pebas.pebasdelivery.domain.form.PessoaForm;
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
    @Column(length = 14, name = "cpf", nullable = false)
    private String cpf;
    @Enumerated(EnumType.ORDINAL)
    @Column(length = 10, name = "genero", nullable = false)
    private GeneroEnum generoEnum;
    @Column(length = 100, name = "email")
    private String email;
    @Column(length = 20, name = "telefone")
    private String telefone;

    public Pessoa newPerson(PessoaForm form) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(form.getNome());
        pessoa.setCpf(form.getCpf());
        pessoa.setGeneroEnum(form.getGeneroEnum());
        pessoa.setEmail(form.getEmail());
        pessoa.setTelefone(form.getTelefone());
        return pessoa;
    }

}
