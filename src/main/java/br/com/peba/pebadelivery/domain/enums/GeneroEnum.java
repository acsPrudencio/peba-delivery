package br.com.peba.pebadelivery.domain.enums;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GeneroEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não-Binário");

    private String descricao;

    public static GeneroEnum valueOfDesciption(String descricao){
        for(GeneroEnum ts : values()){
            if(ts.getDescricao().equalsIgnoreCase(descricao))
                return ts;
        }
        throw new ValidationException("Opção invalida para o gênero escolhido!");
    }
}
