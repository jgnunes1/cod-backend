package br.loja.loja.service.impl;

import org.springframework.stereotype.Service;

import br.loja.loja.dto.CategoriaResponse;
import br.loja.loja.entity.CategoriaEntity;
import br.loja.loja.dto.CategoriaRequest;
import br.loja.loja.repository.CategoriaRepository;
import br.loja.loja.service.CategoriaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // injeta dependências via construtor
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

    private CategoriaEntity convertToEntity(CategoriaRequest request) {
        return CategoriaEntity.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .bgColor(request.getBgColor())
                .imgUrl(request.getImgUrl())
                .build();
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