package br.loja.loja.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {

    private String nome;
    private String descricao;
    private String bgColor;
    private String imgUrl;

}
