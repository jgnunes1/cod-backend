package br.uerj.loja.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_Categoria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoriaId; // Nome em camelCase (boa prática)

    @Column(unique = true)
    private String nome;

    private String descricao;
    private String bgColor;
    private String imgUrl;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column
    private Timestamp updatedAt; // Corrigido para "updatedAt"

    @PrePersist
    protected void gerarCategoriaId() {
        if (this.categoriaId == null) {
            this.categoriaId = UUID.randomUUID().toString();
        }
    }
}