package br.loja.loja.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.loja.loja.dto.CategoriaRequest;
import br.loja.loja.dto.CategoriaResponse;
import br.loja.loja.service.CategoriaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public CategoriaResponse criarCategoria(@RequestBody CategoriaRequest request) {
        return categoriaService.criarCategoria(request);
    }

    @GetMapping
    public List<CategoriaResponse> listarCategorias() {
        return categoriaService.read();
    }

    @DeleteMapping("/{categoriaId}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deletarCategoria(@org.springframework.web.bind.annotation.PathVariable String categoriaId) {
        categoriaService.delete(categoriaId);
    }
}
