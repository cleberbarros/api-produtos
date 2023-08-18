package br.com.bernhoeft.gerenciadorprodutos;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import br.com.bernhoeft.gerenciadorprodutos.service.CategoriaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class CadastroCategoriaIntegrationTests {

	@Autowired
	private CategoriaService categoriaService;

	@Test
	public void testarCadastroCategoriaComSucesso(){

		CategoriaRequest categoriaRequest = CategoriaRequest.builder()
				.nome("Teste")
				.situacao(SituacaoEnum.ATIVO)
				.build();

		CategoriaResponse novaCategoria = this.categoriaService.criar(categoriaRequest);

		assertThat(novaCategoria).isNotNull();
		assertThat(novaCategoria.getId()).isNotNull();
	}

	@Test()
	public void testarCadastroCategoria_QuandoSemNome(){
		CategoriaRequest categoriaRequest = CategoriaRequest.builder()
				.nome(null)
				.situacao(SituacaoEnum.ATIVO)
				.build();
		try {
			categoriaService.criar(categoriaRequest);
		} catch (ConstraintViolationException e) {
			assertThat(e.getMessage()).contains("Por favor informe um nome para a categoria");
		}

	}

}


