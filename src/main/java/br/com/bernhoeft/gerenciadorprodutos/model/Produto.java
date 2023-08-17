package br.com.bernhoeft.gerenciadorprodutos.model;

import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_produto")
@Data
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao;

    private LocalDate validade;

    @Column(name = "CodigoDeBarras")
    private String codigoBarra;

    private String referencia;

    @ManyToOne
    @JoinColumn(name="categoria_id", nullable = false )
    private Categoria categoria;
}
