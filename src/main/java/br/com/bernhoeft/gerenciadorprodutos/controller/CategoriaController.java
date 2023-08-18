package br.com.bernhoeft.gerenciadorprodutos.controller;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import br.com.bernhoeft.gerenciadorprodutos.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping("criar")
    public ResponseEntity criar(@RequestBody @Valid CategoriaRequest categoriaRequest){
       return ResponseEntity.ok(this.categoriaService.criar(categoriaRequest));
    }

    @PutMapping("alterar/{idCategoria}")
    public CategoriaResponse alterar(@PathVariable Long idCategoria, @RequestBody CategoriaRequest categoriaRequest){
        Categoria categoriaAtual = categoriaService.buscar(idCategoria);

        return categoriaService.alterar(categoriaAtual,categoriaRequest);

    }

    @GetMapping("listar")
    public ResponseEntity<List<CategoriaResponse>> listar(){
        return ResponseEntity.ok(this.categoriaService.listar());
    }
    @GetMapping("listar/nome/{nomeCategoria}")
    public ResponseEntity<List<CategoriaResponse>> listarPorNome(@PathVariable String nomeCategoria){
        return ResponseEntity.ok(this.categoriaService.listarPorNome(nomeCategoria));
    }

    @GetMapping("listar/situacao/{situacaoCategoria}")
    public ResponseEntity<List<CategoriaResponse>> listarPorSituacao(@PathVariable SituacaoEnum situacaoCategoria){
        return ResponseEntity.ok(this.categoriaService.listarPorSituacao(situacaoCategoria));
    }

}
