package br.loja.loja.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaResponse {

    private Long id;
    private String categoriaId; 
    private String nome;
    private String descricao;
    private String bgColor;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imgUrl;

}