package br.com.bernhoeft.gerenciadorprodutos.controller;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.request.ProdutoRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.ProdutoResponse;
import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.model.Produto;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import br.com.bernhoeft.gerenciadorprodutos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("criar")
    public ResponseEntity criar(@RequestBody @Valid ProdutoRequest produtoRequest){
        return ResponseEntity.ok(this.produtoService.criar(produtoRequest));
    }

    @PutMapping("alterar")
    public ProdutoResponse alterar(@RequestBody ProdutoRequest produtoRequest){
        Produto produtoAtual = produtoService.buscar(produtoRequest.getId());
        return produtoService.alterar(produtoAtual,produtoRequest);
    }

    @GetMapping("listar")
    public ResponseEntity<List<ProdutoResponse>> listar(){
        return ResponseEntity.ok(this.produtoService.listar());
    }

    @GetMapping("listar/porcategoria/{idCategoria}")
    public ResponseEntity<List<ProdutoResponse>> listarPorCategoria(@PathVariable Long idCategoria){
        return ResponseEntity.ok(this.produtoService.listarPorCategoria(idCategoria));
    }

    @GetMapping("listar/descricao/{descricaoProduto}")
    public ResponseEntity<List<ProdutoResponse>> listarPorDescricao(@PathVariable String descricaoProduto){
        return ResponseEntity.ok(this.produtoService.listarPorNome(descricaoProduto));
    }

    @GetMapping("listar/situacao/{situacaoProduto}")
    public ResponseEntity<List<ProdutoResponse>> listarPorSituacao(@PathVariable SituacaoEnum situacaoProduto){
        return ResponseEntity.ok(this.produtoService.listarPorSituacao(situacaoProduto));
    }
}
