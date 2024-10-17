package com.projeto.dio.spring.model;

import com.projeto.dio.spring.dto.ProdutoRequestDTO;
import com.projeto.dio.spring.dto.ProdutoResponseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public void converterDTO(ProdutoRequestDTO produtoRequestDTO) {
        this.nome = produtoRequestDTO.nome();
        this.valor = produtoRequestDTO.valor();
        this.quantidade = produtoRequestDTO.quantidade();
    }

    public void converterDTO(ProdutoResponseDTO produtoResponseDTO) {
        this.id = produtoResponseDTO.id();
        this.nome = produtoResponseDTO.nome();
        this.valor = produtoResponseDTO.valor();
        this.quantidade = produtoResponseDTO.quantidade();
    }
}
