package br.com.bernhoeft.gerenciadorprodutos.controller.response;

import br.com.bernhoeft.gerenciadorprodutos.model.Produto;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CategoriaResponse {
    private Long id;

    private String nome;

    private SituacaoEnum situacao;

    //private List<Produto> produtos = new ArrayList<>();
}
