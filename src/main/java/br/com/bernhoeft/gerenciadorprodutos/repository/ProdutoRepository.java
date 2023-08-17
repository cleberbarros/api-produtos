package br.com.bernhoeft.gerenciadorprodutos.repository;

import br.com.bernhoeft.gerenciadorprodutos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
