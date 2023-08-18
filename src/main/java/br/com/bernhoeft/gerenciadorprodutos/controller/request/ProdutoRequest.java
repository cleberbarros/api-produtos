package br.com.bernhoeft.gerenciadorprodutos.controller.request;

import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class ProdutoRequest {

    private Long id;

    @NotEmpty(message = "Por favor informe um nome para o Produto ")
    private String nome;

    @NotEmpty(message = "Por favor informe uma descrição para o Produto ")
    private String descricao;

    private BigDecimal preco;

    private SituacaoEnum situacao;

    private LocalDate validade;

    private String codigoBarra;

    private String referencia;

    private Long categoriaId;

}
