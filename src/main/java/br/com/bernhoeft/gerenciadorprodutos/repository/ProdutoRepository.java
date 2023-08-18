package br.com.bernhoeft.gerenciadorprodutos.repository;

import br.com.bernhoeft.gerenciadorprodutos.model.Produto;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaId(Long categoriaId);
    List<Produto> findByDescricaoIgnoreCaseContaining(String nome);
    List<Produto> findBySituacao(SituacaoEnum situacao);
}
