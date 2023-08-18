package br.com.bernhoeft.gerenciadorprodutos.controller.request;

import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
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

    private Long id;

    @NotEmpty(message = "Por favor informe um nome para a categoria")
    private String nome;

    private SituacaoEnum situacao;

}
