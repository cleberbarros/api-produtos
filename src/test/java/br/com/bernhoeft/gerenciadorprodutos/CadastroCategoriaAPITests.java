package br.com.bernhoeft.gerenciadorprodutos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.transaction.Transactional;


@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class CadastroCategoriaAPITests {

	@LocalServerPort
	private int port;

	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

	}

	@Test
	public void deveRetornarStatus200_QuandoConsultaCategorias(){
			RestAssured.given()
				.basePath("/api-produtos/categoria/listar")
				.port(port)
				.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(200);
	}

	@Test
	public void deveRetornarSucesso_QuandoCadatrarCategoria(){
		RestAssured.given()
				.basePath("/api-produtos/categoria/criar")
				.port(port)
				.body(getClass().getResourceAsStream("/jsons/categoria-criar.json"))
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.post()
			.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveRetornarComErro_QuandoCadatrarCategoria(){
		RestAssured.given()
				.basePath("/api-produtos/categoria/criar")
				.port(port)
				.body(getClass().getResourceAsStream("/jsons/categoria-criar-comErro.json"))
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.post()
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value());
	}
}


