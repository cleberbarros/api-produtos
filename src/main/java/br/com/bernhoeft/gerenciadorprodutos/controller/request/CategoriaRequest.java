package br.com.bernhoeft.gerenciadorprodutos.controller.request;

import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CategoriaRequest {

    @NotEmpty(message = "Por favor informe um nome para a categoria")
    private String nome;

    @NotEmpty(message = "Por favor informe a situação ATIVO/INATIVO")
    private SituacaoEnum situacao;

}
