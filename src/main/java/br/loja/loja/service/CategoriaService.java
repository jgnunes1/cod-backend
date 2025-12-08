package br.loja.loja.service;

import br.loja.loja.dto.CategoriaResponse;
import br.loja.loja.dto.CategoriaRequest;

public interface CategoriaService {

        CategoriaResponse criarCategoria(CategoriaRequest request);
    
}
