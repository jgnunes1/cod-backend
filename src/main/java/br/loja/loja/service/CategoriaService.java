package br.loja.loja.service;

import java.util.List;
import br.loja.loja.dto.CategoriaResponse;
import br.loja.loja.dto.CategoriaRequest;

public interface CategoriaService {

        CategoriaResponse criarCategoria(CategoriaRequest request);

                List<CategoriaResponse> read();

                void delete(String categoriaId);
    
}
