package br.loja.loja.repository;

import br.loja.loja.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional, mas recomendado para clareza
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    
}