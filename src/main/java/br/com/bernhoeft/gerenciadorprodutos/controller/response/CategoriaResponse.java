package br.com.bernhoeft.gerenciadorprodutos.controller.response;

import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CategoriaResponse {
    private Long id;

    private String nome;

    private SituacaoEnum situacao;

}
