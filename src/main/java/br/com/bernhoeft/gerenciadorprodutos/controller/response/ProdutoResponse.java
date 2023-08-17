package br.com.bernhoeft.gerenciadorprodutos.controller.response;

import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class ProdutoResponse {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private SituacaoEnum situacao;

    private LocalDate validade;

    private String codigoBarra;

    private String referencia;

    private Categoria categoria;

}
