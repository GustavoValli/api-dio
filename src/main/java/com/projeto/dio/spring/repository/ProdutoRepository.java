package com.projeto.dio.spring.repository;

import com.projeto.dio.spring.dto.ProdutoResponseDTO;
import com.projeto.dio.spring.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<ProdutoResponseDTO> findByNome(String nome);
}
