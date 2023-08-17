package br.com.bernhoeft.gerenciadorprodutos.service;

import br.com.bernhoeft.gerenciadorprodutos.controller.request.CategoriaRequest;
import br.com.bernhoeft.gerenciadorprodutos.controller.response.CategoriaResponse;
import br.com.bernhoeft.gerenciadorprodutos.model.Categoria;
import br.com.bernhoeft.gerenciadorprodutos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;


    public void criar(CategoriaRequest categoriaRequest) {
        //Categoria categoria = modelMapper.map(categoriaRequest, Categoria.class);

        Categoria categoria = new Categoria();
                categoria.setNome(categoriaRequest.getNome());
                categoria.setSituacao(categoriaRequest.getSituacao());

    }
}
