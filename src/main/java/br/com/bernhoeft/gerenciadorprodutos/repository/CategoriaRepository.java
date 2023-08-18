package br.com.bernhoeft.gerenciadorprodutos.repository;

import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByNomeIgnoreCaseContaining(String nome);
    List<Categoria> findBySituacao(SituacaoEnum situacao);
}
