package br.uerj.loja.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import br.uerj.loja.dto.CategoriaRequest;
import br.uerj.loja.dto.CategoriaResponse;

public interface CategoriaService {

    CategoriaResponse criarCategoria(CategoriaRequest request);

    // Cria categoria com upload de arquivo (multipart)
    CategoriaResponse criarCategoria(CategoriaRequest request, MultipartFile file);

    List<CategoriaResponse> read();

    CategoriaResponse atualizarCategoria(String categoriaId, CategoriaRequest request);

    void delete(String categoriaId);
}
