package br.com.bernhoeft.gerenciadorprodutos.repository;

import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
