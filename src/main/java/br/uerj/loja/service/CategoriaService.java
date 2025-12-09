package br.uerj.loja.service;

import java.util.List;

import br.uerj.loja.dto.CategoriaRequest;
import br.uerj.loja.dto.CategoriaResponse;

public interface CategoriaService {

        CategoriaResponse criarCategoria(CategoriaRequest request);

                List<CategoriaResponse> read();

                void delete(String categoriaId);
    
}
