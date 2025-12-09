package br.uerj.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {

    private String nome;
    private String descricao;
    private String bgColor;
    private String imgUrl;

}
