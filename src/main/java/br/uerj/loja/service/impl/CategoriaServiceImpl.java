package br.uerj.loja.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import br.uerj.loja.dto.CategoriaRequest;
import br.uerj.loja.dto.CategoriaResponse;
import br.uerj.loja.entity.CategoriaEntity;
import br.uerj.loja.repository.CategoriaRepository;
import br.uerj.loja.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public CategoriaResponse criarCategoria(CategoriaRequest request) {
        // Converte o DTO de entrada para entidade
        CategoriaEntity entity = convertToEntity(request);
        
        // Salva no banco
        CategoriaEntity savedEntity = categoriaRepository.save(entity);
        
        // Converte a entidade salva para DTO de resposta
        return convertToResponse(savedEntity);
    }

    @Override
    public List<CategoriaResponse> read() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public CategoriaResponse atualizarCategoria(String categoriaId, CategoriaRequest request) {
        // Busca a categoria por categoriaId
        CategoriaEntity existenteCategoria = categoriaRepository.findAll()
            .stream()
            .filter(cat -> cat.getCategoriaId() != null && cat.getCategoriaId().equals(categoriaId))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada: " + categoriaId));
        
        // Atualiza os campos
        existenteCategoria.setNome(request.getNome());
        existenteCategoria.setDescricao(request.getDescricao());
        existenteCategoria.setBgColor(request.getBgColor());
        existenteCategoria.setImgUrl(request.getImgUrl());
        
        // Salva as alterações
        CategoriaEntity updatedEntity = categoriaRepository.save(existenteCategoria);
        
        return convertToResponse(updatedEntity);
    }

    private CategoriaEntity convertToEntity(CategoriaRequest request) {
        return CategoriaEntity.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .bgColor(request.getBgColor())
                .imgUrl(request.getImgUrl())
                .build();
    }

    @Override
    public void delete (String categoriaId) {
        // Busca todas as categorias e filtra por categoriaId com null-safe
        CategoriaEntity existenteCategoria = categoriaRepository.findAll()
            .stream()
            .filter(cat -> cat.getCategoriaId() != null && cat.getCategoriaId().equals(categoriaId))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada: " + categoriaId));
        categoriaRepository.delete(existenteCategoria);
    }

    private CategoriaResponse convertToResponse(CategoriaEntity entity) {
        return CategoriaResponse.builder()
                .id(entity.getId())
                .categoriaId(entity.getCategoriaId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .bgColor(entity.getBgColor())
                .imgUrl(entity.getImgUrl())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}