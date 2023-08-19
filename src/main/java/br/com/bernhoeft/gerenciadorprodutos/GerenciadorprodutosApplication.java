package br.com.bernhoeft.gerenciadorprodutos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger API Produtos", version="1", description = "API Gerenciador de Produtos"))
public class GerenciadorprodutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorprodutosApplication.class, args);
	}

}
