package br.com.pebas.pebasdelivery.domain.form;

import br.com.pebas.pebasdelivery.domain.enums.GeneroEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class PessoaForm {
    @NonNull
    @NotEmpty
    private String nome;
    @NonNull
    @NotEmpty
    private String cpfCnpj;
    @NonNull
    private GeneroEnum generoEnum;
    @NonNull
    @NotEmpty
    private String email;
    @NonNull
    @NotEmpty
    private String telefone;
}
