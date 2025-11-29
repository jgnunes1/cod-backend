package br.loja.loja.io;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaResquest {


    private String nome;
    private String descricao;
    private String bgColor;
  
    
}