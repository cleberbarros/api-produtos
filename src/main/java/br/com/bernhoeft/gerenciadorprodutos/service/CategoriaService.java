package br.com.bernhoeft.gerenciadorprodutos.service;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final ModelMapper modelMapper;

    public void criar(CategoriaRequest categoriaRequest) {
        //Categoria categoria = modelMapper.map(categoriaRequest, Categoria.class);

        Categoria categoria = new Categoria();
                categoria.setNome(categoriaRequest.getNome());
                categoria.setSituacao(categoriaRequest.getSituacao());
        categoriaRepository.save(categoria);
    }

    public CategoriaResponse toModel(Categoria categoria){
        return modelMapper.map(categoria,CategoriaResponse.class);
    }

    public List<CategoriaResponse> listar(){
        return categoriaRepository.findAll().stream()
                .map(categoria -> toModel(categoria))
                .collect(Collectors.toList());
    }
}
