package br.loja.loja.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaRequest {


    private String nome;
    private String descricao;
    private String bgColor;
    private String imgUrl;
  
    
}