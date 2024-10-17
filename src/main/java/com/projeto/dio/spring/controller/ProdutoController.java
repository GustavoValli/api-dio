package com.projeto.dio.spring.controller;

import com.projeto.dio.spring.dto.ProdutoRequestDTO;
import com.projeto.dio.spring.dto.ProdutoResponseDTO;
import com.projeto.dio.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity adicionarProduto(@RequestBody ProdutoRequestDTO produtoDTO) {
        service.adicionarProduto(produtoDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<ProdutoResponseDTO> pesquisarPorNome(@PathVariable String nome) {
        ProdutoResponseDTO produto = service.pesquisarPorNome(nome);

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity deletarPorNome(@PathVariable String nome) {
        service.deletarPorNome(nome);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{nome}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO, @PathVariable String nome) {
        service.atualizarProduto(produtoRequestDTO, nome);

        return ResponseEntity.ok().build();
    }
}
