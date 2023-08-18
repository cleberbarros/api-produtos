package br.com.bernhoeft.gerenciadorprodutos.service;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.exception.CategoriaNaoEncontradaException;
import br.com.bernhoeft.gerenciadorprodutos.exception.EntidadeNaoEncontradaException;
import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.model.enums.SituacaoEnum;
import br.com.bernhoeft.gerenciadorprodutos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final ModelMapper modelMapper;

    public void criar(CategoriaRequest categoriaRequest) {
       this.categoriaRepository.save(modelMapper.map(categoriaRequest, Categoria.class));
    }

    public List<CategoriaResponse> listarPorNome(String nome) {
        return categoriaRepository.findByNomeIgnoreCaseContaining(nome).stream()
                .map(categoria -> toModel(categoria))
                .collect(Collectors.toList());
    }

    public List<CategoriaResponse> listarPorSituacao(SituacaoEnum situacao) {
        return categoriaRepository.findBySituacao(situacao).stream()
                .map(categoria -> toModel(categoria))
                .collect(Collectors.toList());
    }

    public List<CategoriaResponse> listar(){
        return categoriaRepository.findAll().stream()
                .map(categoria -> toModel(categoria))
                .collect(Collectors.toList());
    }
    public CategoriaResponse toModel(Categoria categoria){
        return modelMapper.map(categoria,CategoriaResponse.class);
    }

public CategoriaResponse alterar(Categoria categoriaEncontrada, CategoriaRequest categoriaRequest) {

        modelMapper.map(categoriaRequest, categoriaEncontrada);
        categoriaRepository.save(categoriaEncontrada);

        return modelMapper.map(categoriaEncontrada, CategoriaResponse.class);
  }


    public Categoria buscar(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(()-> new CategoriaNaoEncontradaException(id));
    }

}
