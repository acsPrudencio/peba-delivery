package br.com.pebas.pebasdelivery.domain.form;

import br.com.pebas.pebasdelivery.domain.enums.GeneroEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PessoaForm {
    @NonNull
    @NotEmpty
    private String nome;
    @NonNull
    @NotEmpty
    private String cpf;
    @NonNull
    private GeneroEnum generoEnum;
    @NonNull
    @NotEmpty
    private String email;
    @NonNull
    @NotEmpty
    private String telefone;
}
