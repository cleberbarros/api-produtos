package br.com.bernhoeft.gerenciadorprodutos;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.request.ProdutoRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.ProdutoResponse;
import br.com.bernhoeft.gerenciadorprodutos.exception.ProdutoNaoEncontradaException;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import br.com.bernhoeft.gerenciadorprodutos.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class CadastroProdutoIntegrationTests {

	@Autowired
	private ProdutoService produtoService;

	@Test
	public void testarCadastroProdutoComSucesso(){

		ProdutoRequest produtoRequest = ProdutoRequest.builder()
				.nome("Nome Produto")
				.descricao("Descrição Produto")
				.preco(BigDecimal.valueOf(88L))
				.situacao(SituacaoEnum.ATIVO)
				.validade(LocalDate.now().plusYears(1))
				.codigoBarra("890009")
				.referencia("REF008")
				.categoria(CategoriaRequest.builder().id(1L).build())
				.build();

		ProdutoResponse novoProduto = this.produtoService.criar(produtoRequest);

		assertThat(novoProduto).isNotNull();
		assertThat(novoProduto.getId()).isNotNull();
	}

	@Test()
	public void testarCadastroProduto_QuandoSemNome(){
		ProdutoRequest produtoRequest = ProdutoRequest.builder()
				.nome(null)
				.descricao("Descrição Produto")
				.preco(BigDecimal.valueOf(88L))
				.situacao(SituacaoEnum.ATIVO)
				.validade(LocalDate.now().plusYears(1))
				.codigoBarra("890009")
				.referencia("REF008")
				.categoria(CategoriaRequest.builder().id(1L).build())
				.build();
		try {
			produtoService.criar(produtoRequest);
		} catch (ConstraintViolationException e) {
			assertThat(e.getMessage()).contains("Por favor informe um nome para o produto");
		}

	}

	@Test()
	public void testaAlterarProdutoInexistente(){
		Long idProduto = 999L;

		assertThatExceptionOfType(ProdutoNaoEncontradaException.class)
				.isThrownBy(() -> produtoService.buscar(idProduto))
				.withMessageContaining("Não existe um cadastro de produto com código " + idProduto);
	}

}


