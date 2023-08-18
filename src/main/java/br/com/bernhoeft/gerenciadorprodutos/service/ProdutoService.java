package br.com.bernhoeft.gerenciadorprodutos.service;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.request.ProdutoRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.ProdutoResponse;
import br.com.bernhoeft.gerenciadorprodutos.exception.ProdutoNaoEncontradaException;
import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.model.Produto;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import br.com.bernhoeft.gerenciadorprodutos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final ModelMapper modelMapper;

    public ProdutoResponse criar(ProdutoRequest produtoRequest) {
        Produto produtoSalvo = this.produtoRepository.save(modelMapper.map(produtoRequest, Produto.class));
        return modelMapper.map(produtoSalvo, ProdutoResponse.class);
    }

    public ProdutoResponse alterar(Produto produtoEncontrada, ProdutoRequest produtoRequest) {

        modelMapper.map(produtoRequest, produtoEncontrada);
        produtoRepository.save(produtoEncontrada);

        return modelMapper.map(produtoEncontrada, ProdutoResponse.class);
    }

    public List<ProdutoResponse> listar(){
        return produtoRepository.findAll().stream()
                .map(produto -> toModel(produto))
                .collect(Collectors.toList());
    }

    public List<ProdutoResponse> listarPorCategoria(Long idCategoria){
        return produtoRepository.findByCategoriaId(idCategoria).stream()
                .map(produto -> toModel(produto))
                .collect(Collectors.toList());
    }

    public List<ProdutoResponse> listarPorNome(String descricao) {
        return produtoRepository.findByDescricaoIgnoreCaseContaining(descricao).stream()
                .map(produto -> toModel(produto))
                .collect(Collectors.toList());
    }

    public List<ProdutoResponse> listarPorSituacao(SituacaoEnum situacao) {
        return produtoRepository.findBySituacao(situacao).stream()
                .map(produto -> toModel(produto))
                .collect(Collectors.toList());
    }

    public ProdutoResponse toModel(Produto produto){
        return modelMapper.map(produto,ProdutoResponse.class);
    }

    public Produto buscar(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(()-> new ProdutoNaoEncontradaException(id));
    }

}
