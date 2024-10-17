package com.projeto.dio.spring.service;

import com.projeto.dio.spring.dto.ProdutoRequestDTO;
import com.projeto.dio.spring.dto.ProdutoResponseDTO;
import com.projeto.dio.spring.model.Produto;
import com.projeto.dio.spring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void adicionarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.converterDTO(produtoRequestDTO);

        repository.save(produto);
    }

    public ProdutoResponseDTO pesquisarPorNome(String nome) {
        Optional<ProdutoResponseDTO> optional = repository.findByNome(nome);

        return optional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarPorNome(String nome) {
        Optional<ProdutoResponseDTO> responseDTO = repository.findByNome(nome);

        if (!responseDTO.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Produto produto = new Produto();
        produto.converterDTO(responseDTO.get());

        repository.delete(produto);
    }

    public void atualizarProduto(ProdutoRequestDTO requestDTO, String nome) {
        Optional<ProdutoResponseDTO> optional = repository.findByNome(nome);

        if (optional.isPresent()) {
            ProdutoResponseDTO responseDTO = optional.get();

            Produto produto = new Produto();
            produto.setId(responseDTO.id());
            produto.converterDTO(requestDTO);

            repository.save(produto);
        }
    }
}
