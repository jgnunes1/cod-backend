package br.uerj.loja.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uerj.loja.dto.CategoriaRequest;
import br.uerj.loja.dto.CategoriaResponse;
import br.uerj.loja.service.CategoriaService;
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

    @PutMapping("/{categoriaId}")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public CategoriaResponse atualizarCategoria(
            @org.springframework.web.bind.annotation.PathVariable String categoriaId,
            @RequestBody CategoriaRequest request) {
        return categoriaService.atualizarCategoria(categoriaId, request);
    }

    @DeleteMapping("/{categoriaId}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deletarCategoria(@org.springframework.web.bind.annotation.PathVariable String categoriaId) {
        categoriaService.delete(categoriaId);
    }
}
