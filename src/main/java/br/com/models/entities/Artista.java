package br.com.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pd_artistas")
@AllArgsConstructor@NoArgsConstructor
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrica", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Album> albuns;
}
