package br.uerj.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {

    private String nome;
    private String descricao;
    private String bgColor;
    private String imgUrl;

}
