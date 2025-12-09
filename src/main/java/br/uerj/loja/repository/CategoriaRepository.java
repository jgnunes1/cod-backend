package br.uerj.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uerj.loja.entity.CategoriaEntity;

@Repository // opcional, mas recomendado para clareza
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    
    Optional<CategoriaEntity> findByCategoriaId(String categoriaId); // Método para buscar por categoriaId, se necessário
}